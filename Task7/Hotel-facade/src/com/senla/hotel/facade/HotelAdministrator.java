/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.facade;

import com.senla.hotel.api.facade.IHotelAdministrator;
import com.senla.hotel.api.managers.IGuestManager;
import com.senla.hotel.api.managers.IHistoryManager;
import com.senla.hotel.api.managers.IRoomManager;
import com.senla.hotel.api.managers.IServiceManager;
import com.senla.hotel.comparators.GuestComparator;
import com.senla.hotel.comparators.RoomComparator;
import com.senla.hotel.comparators.ServiceComparator;
import com.senla.hotel.configuration.Configuration;
import com.senla.hotel.managers.ServiceManager;
import com.senla.hotel.managers.RoomManager;
import com.senla.hotel.managers.HistoryManager;
import com.senla.hotel.managers.GuestManager;
import com.senla.hotel.enums.RoomStatus;
import com.senla.hotel.factory.ManagerFactory;
import com.senla.hotel.reflection.Reflection;
import com.senla.hotel.utils.DateConverter;
import com.senla.hotel.utils.Logger;
import com.senla.hotel.utils.TextWorker;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

public class HotelAdministrator implements IHotelAdministrator {

    private final TextWorker textWorker;
    private final IGuestManager guestManager;
    private final IRoomManager roomManager;
    private final IServiceManager serviceManager;
    private final IHistoryManager historyManager;
    private final Logger logger;
    private final DateConverter dateConverter;
    private static HotelAdministrator hotelAdministrator;
    private static Configuration configuration;
    private final Reflection reflection;
    private final ManagerFactory managerFactory;

    private HotelAdministrator() {
        managerFactory = new ManagerFactory();
        configuration = new Configuration();
        textWorker = new TextWorker();
        dateConverter = new DateConverter();
        logger = new Logger();
        roomManager =  (IRoomManager)managerFactory.getObject(RoomManager.class,(configuration.getRoomPath()));
        guestManager = (IGuestManager)managerFactory.getObject(GuestManager.class,(configuration.getGuestPath()));
        serviceManager = (IServiceManager)managerFactory.getObject(ServiceManager.class,(configuration.getServicePath()));
        historyManager = (IHistoryManager)managerFactory.getObject(HistoryManager.class,(configuration.getHistoryPath()));
        reflection = new Reflection(configuration.getCsvPath());
        readData();
    }

    public static HotelAdministrator getInstance() {
        if (hotelAdministrator == null) {
            hotelAdministrator = new HotelAdministrator();
        }
        return hotelAdministrator;
    }

    @Override
    public String getGuestPriceForAccommodation(Integer guestId, Integer numberRoom) {
        try {
            return historyManager.getGuestPriceForAccommodation(guestManager.getGuestByID(guestId), roomManager.getRoom(numberRoom)).toString();
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
            return null;
        }
    }

    @Override
    public void changeNumberOfStars(Integer numberOfRoom, Integer numberOfStars) {
        roomManager.changeNumberOfStars(numberOfRoom, numberOfStars);
    }

    @Override
    public void changeCapacity(Integer numberOfRoom, Integer capacity) {
        roomManager.changeCapacity(numberOfRoom, capacity);
    }

    @Override
    public void writeData() {
        guestManager.serializeData();
        roomManager.serializeData();
        historyManager.serializeData();
        serviceManager.serializeData();
    }

    @Override
    public void createRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, Integer id, RoomStatus status) {
        try {
            roomManager.createRoom(number, price, capacity, numberOfStars, id, status);
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry data", e);
        }
    }

    @Override
    public void copyRoom(Integer numberOfRoom, Integer newId, Integer newNumber) {

        roomManager.copyRoom(numberOfRoom, newId, newNumber);

    }

    @Override
    public void createGuest(String name, String arrivalDate, String dateOfDeparture, Integer id) {
        try {
            guestManager.createGuest(name, dateConverter.parseDate(arrivalDate), dateConverter.parseDate(dateOfDeparture), id);
        } catch (ParseException e) {
            logger.writeErrToFile("Wrong entry date", e);

        }
    }

    @Override
    public void importRooms() {
        try {
            roomManager.setImportRooms(reflection.importRoom());

        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ParseException e) {
            logger.writeErrToFile("Problem with reflection ", e);
        }
    }

    @Override
    public void exportRooms() {
        try {
            reflection.exportData(roomManager.getRooms());
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | IOException ex) {
            logger.writeErrToFile("Problem with reflection", ex);
        }

    }

    @Override
    public void importServices() {
        try {
            serviceManager.setImportServices(reflection.importService());

        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ParseException e) {
            logger.writeErrToFile("Problem with reflection ", e);
        }

    }

    @Override
    public void exportServices() {
        try {
            reflection.exportData(serviceManager.getServices());
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | IOException ex) {
            logger.writeErrToFile("Problem with reflection", ex);
        }
    }

    @Override
    public void importGuests() {
        try {
            guestManager.setImpotrGuests(reflection.importGuest());

        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ParseException e) {
            logger.writeErrToFile("Problem with reflection ", e);
        }

    }

    @Override
    public void exportGuests() {
        try {
            reflection.exportData(guestManager.getGuests());
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | IOException ex) {
            logger.writeErrToFile("Problem with reflection", ex);
        }
    }

    @Override
    public Integer getGuestIdByNumberOnList(Integer number) {
        try {
            return guestManager.getIdByNumberOnList(number);
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
        return null;
    }

    @Override
    public Integer getRoomNumberByNumberOnList(Integer number) {
        try {
            return roomManager.getIdByNumberOnList(number);
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
        return null;
    }

    @Override
    public Integer getServiceIdByNumberOnList(Integer number) {
        try {
            return serviceManager.getIdByNumberOnList(number);
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
        return null;
    }

    @Override
    public void createService(Integer price, String category, Integer id) {
        try {
            serviceManager.createService(price, category, id);
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry data", e);

        }
    }

    private void readData() {
        guestManager.deserializeData();
        roomManager.deserializeData();
        historyManager.deserializeData();
        serviceManager.deserializeData();
    }

    @Override
    public void changeRoomPrice(Integer numberOfRoom, Integer price) {
        try {
            roomManager.changeRoomPrice(numberOfRoom, price);
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
    }

    @Override
    public void changeServicePrice(Integer serviceId, Integer price) {
        try {
            serviceManager.changeServicePrice(serviceId, price);
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
    }

    @Override
    public String getListOfRoomsAvailableByDate(String date) {
        try {

            return textWorker.createRoomList(historyManager.getListOfRoomsAvailableByDate(dateConverter.parseDate(date), roomManager.getRooms()), null);
        } catch (ParseException e) {
            logger.writeErrToFile("Wrong entry date", e);

            return null;
        }
    }

    @Override
    public Boolean getRoomAbility() {
        return configuration.getAbilityChangeRoomStatus();
    }

    @Override
    public void changeRoomStatus(Integer numberOfRoom, RoomStatus status) {

        try {
            roomManager.changeRoomStatus(numberOfRoom, status);
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
    }

    @Override
    public void addServiceToGuest(Integer serviceId, Integer guestId, Integer numberRoom) {
        try {
            historyManager.addServiceToGuest(serviceManager.getService(serviceId), guestManager.getGuestByID(guestId), roomManager.getRoom(numberRoom));
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
    }

    @Override
    public void settleInRoom(Integer guestId, Integer numberOfRoom) {
        try {
            roomManager.changeRoomBusy(numberOfRoom, Boolean.TRUE);
            historyManager.settleInRoom(guestManager.getGuestByID(guestId), roomManager.getRoom(numberOfRoom));
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
    }

    @Override
    public void evictedFromRoom(Integer guestId, Integer numberOfRoom) {
        try {
            historyManager.evictedFromRoom(guestManager.getGuestByID(guestId), roomManager.getRoom(numberOfRoom));
            if (historyManager.checkForPresenceGuestsInRoom(roomManager.getRoom(numberOfRoom)) == true) {
                roomManager.changeRoomBusy(numberOfRoom, Boolean.FALSE);
            }
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }

    }

    @Override
    public String getNumberGuestInHotel() {

        return historyManager.getNumberGuestInHotel().toString();

    }

    @Override
    public String getNumberEmptyRoomInHotel() {

        return roomManager.getNumberEmptyRoomInHotel().toString();

    }

    @Override
    public String getListOfServices() {
        return textWorker.createServiceList(serviceManager.getServices());
    }

    @Override
    public String getListLeftGuestThisRoom(Integer numberOfRoom) {
        try {
            return textWorker.createGuestList(historyManager.getListLeftGuestThisRoom(roomManager.getRoom(numberOfRoom), configuration.getNumberRecordsGuests()));
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
            return null;
        }
    }

    @Override
    public String getDetailsOfRoom(Integer numberOfRoom) {
        try {
            return textWorker.createRoomList(roomManager.getDetailsOfRoom(numberOfRoom), null);

        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
            return null;
        }
    }

    @Override
    public String getSortRoomsByCapacity() {
        roomManager.sorting(new RoomComparator().getCapacityComparator());
        return textWorker.createRoomList(roomManager.getRooms(), null);

    }

    @Override
    public String getSortRoomsByPrice() {
        roomManager.sorting(new RoomComparator().getPriceComparator());
        return textWorker.createRoomList(roomManager.getRooms(), null);
    }

    @Override
    public String getSortRoomsByNumberOfStars() {
        roomManager.sorting(new RoomComparator().getNumberStarsComparator());
        return textWorker.createRoomList(roomManager.getRooms(), null);
    }

    @Override
    public String getSortEmptyRoomsByCapacity() {

        roomManager.sorting(new RoomComparator().getBusyComparator(), new RoomComparator().getCapacityComparator());
        return textWorker.createRoomList(roomManager.getRooms(), roomManager.getNumberEmptyRoomInHotel());
    }

    @Override
    public String getSortEmptyRoomsByPrice() {
        roomManager.sorting(new RoomComparator().getBusyComparator(), new RoomComparator().getPriceComparator());
        return textWorker.createRoomList(roomManager.getRooms(), roomManager.getNumberEmptyRoomInHotel());

    }

    @Override
    public String getSortEmptyRoomsByNumberOfStars() {
        roomManager.sorting(new RoomComparator().getBusyComparator(), new RoomComparator().getNumberStarsComparator());
        return textWorker.createRoomList(roomManager.getRooms(), roomManager.getNumberEmptyRoomInHotel());

    }

    @Override
    public String getSortGuestByDateOfDeparture() {
        guestManager.sorting(new GuestComparator().getDateComparator());
        return textWorker.createGuestList(guestManager.getGuests());

    }

    @Override
    public String getSortListServiceGuestByPrice(Integer guestId, Integer numberRoom) {
        historyManager.sorting(guestManager.getGuestByID(guestId), new ServiceComparator().getServiceByPriceComparator(), roomManager.getRoom(numberRoom));
        return textWorker.createServiceList(historyManager.getGuestServices(guestManager.getGuestByID(guestId), roomManager.getRoom(numberRoom)));
    }

    @Override
    public String getSortListServiceGuestByCategory(Integer guestId, Integer numberRoom) {

        historyManager.sorting(guestManager.getGuestByID(guestId), new ServiceComparator().getServiceByCategoryComparator(), roomManager.getRoom(numberRoom));
        return textWorker.createServiceList(historyManager.getGuestServices(guestManager.getGuestByID(guestId), roomManager.getRoom(numberRoom)));
    }

    @Override
    public String getSortGuestByName() {
        guestManager.sorting(new GuestComparator().getNameComparator());
        return textWorker.createGuestList(guestManager.getGuests());
    }
}
