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
import com.senla.hotel.entity.Guest;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;
import com.senla.hotel.factory.ManagerFactory;
import com.senla.hotel.csv.CsvWorker;
import com.senla.hotel.utils.DateConverter;
import com.senla.hotel.utils.Logger;
import com.senla.hotel.utils.DataParser;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

public class HotelAdministrator implements IHotelAdministrator {

    private final DataParser textWorker;
    private final IGuestManager guestManager;
    private final IRoomManager roomManager;
    private final IServiceManager serviceManager;
    private final IHistoryManager historyManager;
    private final Logger logger;
    private final DateConverter dateConverter;
    private static HotelAdministrator hotelAdministrator;
    private static Configuration configuration;
    private final CsvWorker csvWorker;
    private final ManagerFactory managerFactory;
    private final DataParser dataParser;

    private HotelAdministrator() {
        dataParser = new DataParser();
        configuration = new Configuration();
        managerFactory = new ManagerFactory(configuration.getInjectProperties());
        textWorker = new DataParser();
        dateConverter = new DateConverter();
        logger = new Logger();
        roomManager = (IRoomManager) managerFactory.getObject(IRoomManager.class, (configuration.getRoomPath()));
        guestManager = (IGuestManager) managerFactory.getObject(IGuestManager.class, (configuration.getGuestPath()));
        serviceManager = (IServiceManager) managerFactory.getObject(IServiceManager.class, (configuration.getServicePath()));
        historyManager = (IHistoryManager) managerFactory.getObject(IHistoryManager.class, (configuration.getHistoryPath()));
        csvWorker = new CsvWorker(configuration.getCsvPath());
        readData();
    }

    public static IHotelAdministrator getInstance() {
        if (hotelAdministrator == null) {
            hotelAdministrator = new HotelAdministrator();
        }
        return hotelAdministrator;
    }

    @Override
    public synchronized String getGuestPriceForAccommodation(String guestId, String numberRoom) {
        try {
            return historyManager.getGuestPriceForAccommodation(guestManager.getGuestByID(getGuestIdByNumberOnList(Integer.parseInt(guestId))), roomManager.getRoom(getRoomNumberByNumberOnList(Integer.parseInt(numberRoom)))).toString();
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
            return null;
        }
    }

    @Override
    public synchronized void changeNumberOfStars(String numberOfRoom, String numberOfStars) {
        roomManager.changeNumberOfStars(getRoomNumberByNumberOnList(Integer.parseInt(numberOfRoom)), Integer.parseInt(numberOfStars));
    }

    @Override
    public synchronized void changeCapacity(String numberOfRoom, String capacity) {
        roomManager.changeCapacity(getRoomNumberByNumberOnList(Integer.parseInt(numberOfRoom)), Integer.parseInt(capacity));
    }

    @Override
    public void writeData() {

        guestManager.serializeData();
        roomManager.serializeData();
        historyManager.serializeData();
        serviceManager.serializeData();
    }

    @Override
    public synchronized void createRoom(String number, String price, String capacity, String numberOfStars, String id, String status) {
        try {
            roomManager.createRoom(Integer.parseInt(number), Integer.parseInt(price), Integer.parseInt(capacity), Integer.parseInt(numberOfStars), Integer.parseInt(id), dataParser.getRoomStatus(status));
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry data", e);
        }
    }

    @Override
    public synchronized void copyRoom(String numberOfRoom, String newId, String newNumber) {

        roomManager.copyRoom(getRoomNumberByNumberOnList(Integer.parseInt(numberOfRoom)), Integer.parseInt(newId), Integer.parseInt(newNumber));

    }

    @Override
    public synchronized void createGuest(String name, String arrivalDate, String dateOfDeparture, String id) {
        try {
            guestManager.createGuest(name, dateConverter.parseDate(arrivalDate), dateConverter.parseDate(dateOfDeparture), Integer.parseInt(id));
        } catch (ParseException e) {
            logger.writeErrToFile("Wrong entry date", e);

        }
    }

    @Override
    public synchronized void importRooms() {

        try {
            roomManager.setImportRooms(csvWorker.importData(Room.class));

        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ParseException e) {
            logger.writeErrToFile("Problem with reflection ", e);
        }

    }

    @Override
    public synchronized void exportRooms() {

        try {
            csvWorker.exportData(roomManager.getRooms());
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | IOException ex) {
            logger.writeErrToFile("Problem with reflection", ex);
        }
    }

    @Override
    public synchronized void importServices() {

        try {
            serviceManager.setImportServices(csvWorker.importData(Service.class));
        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ParseException e) {
            logger.writeErrToFile("Problem with reflection ", e);
        }

    }

    @Override
    public synchronized void exportServices() {

        try {
            csvWorker.exportData(serviceManager.getServices());
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | IOException ex) {
            logger.writeErrToFile("Problem with reflection", ex);
        }

    }

    @Override
    public synchronized void importGuests() {

        try {
            guestManager.setImpotrGuests(csvWorker.importData(Guest.class));
        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ParseException e) {
            logger.writeErrToFile("Problem with reflection ", e);
        }

    }

    @Override
    public synchronized void exportGuests() {

        try {
            csvWorker.exportData(guestManager.getGuests());
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | IOException ex) {
            logger.writeErrToFile("Problem with reflection", ex);
        }

    }

    @Override
    public synchronized Integer getGuestIdByNumberOnList(Integer number) {
        try {
            return guestManager.getIdByNumberOnList(number);
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
        return null;
    }

    @Override
    public synchronized Integer getRoomNumberByNumberOnList(Integer number) {
        try {
            return roomManager.getIdByNumberOnList(number);
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
        return null;
    }

    @Override
    public synchronized Integer getServiceIdByNumberOnList(Integer number) {
        try {
            return serviceManager.getIdByNumberOnList(number);
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
        return null;
    }

    @Override
    public synchronized void createService(String price, String category, String id) {
        try {
            serviceManager.createService(Integer.parseInt(price), category, Integer.parseInt(id));
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
    public synchronized void changeRoomPrice(String numberOfRoom, String price) {
        try {
            roomManager.changeRoomPrice(getRoomNumberByNumberOnList(Integer.parseInt(numberOfRoom)), Integer.parseInt(price));
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
    }

    @Override
    public synchronized void changeServicePrice(String serviceId, String price) {
        try {
            serviceManager.changeServicePrice(getServiceIdByNumberOnList(Integer.parseInt(serviceId)), Integer.parseInt(price));
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
    }

    @Override
    public synchronized String getListOfRoomsAvailableByDate(String date) {
        try {

            return textWorker.createRoomList(historyManager.getListOfRoomsAvailableByDate(dateConverter.parseDate(date), roomManager.getRooms()), null);
        } catch (ParseException e) {
            logger.writeErrToFile("Wrong entry date", e);

            return null;
        }
    }

    @Override
    public synchronized Boolean getRoomAbility() {
        return configuration.getAbilityChangeRoomStatus();
    }

    @Override
    public synchronized void changeRoomStatus(String numberOfRoom, String status) {
        try {
            roomManager.changeRoomStatus(getRoomNumberByNumberOnList(Integer.parseInt(numberOfRoom)), dataParser.getRoomStatus(status));
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
    }

    @Override
    public synchronized void addServiceToGuest(String serviceId, String guestId, String numberRoom) {
        try {

            historyManager.addServiceToGuest(serviceManager.getService(getServiceIdByNumberOnList(Integer.parseInt(serviceId))), guestManager.getGuestByID(getGuestIdByNumberOnList(Integer.parseInt(guestId))), roomManager.getRoom(getRoomNumberByNumberOnList(Integer.parseInt(numberRoom))));
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
    }

    @Override
    public synchronized void settleInRoom(String guestId, String numberOfRoom) {
        try {
            roomManager.changeRoomBusy(getRoomNumberByNumberOnList(Integer.parseInt(numberOfRoom)), Boolean.TRUE);
            historyManager.settleInRoom(guestManager.getGuestByID(getGuestIdByNumberOnList(Integer.parseInt(guestId))), roomManager.getRoom(getRoomNumberByNumberOnList(Integer.parseInt(numberOfRoom))));
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
    }

    @Override
    public synchronized void evictedFromRoom(String guestId, String numberOfRoom) {
        try {
            historyManager.evictedFromRoom(guestManager.getGuestByID(getGuestIdByNumberOnList(Integer.parseInt(guestId))), roomManager.getRoom(getRoomNumberByNumberOnList(Integer.parseInt(numberOfRoom))));
            if (historyManager.checkForPresenceGuestsInRoom(roomManager.getRoom(getRoomNumberByNumberOnList(Integer.parseInt(numberOfRoom)))) == true) {
                roomManager.changeRoomBusy(getRoomNumberByNumberOnList(Integer.parseInt(numberOfRoom)), Boolean.FALSE);
            }
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }

    }

    @Override
    public synchronized String getNumberGuestInHotel() {

        return historyManager.getNumberGuestInHotel().toString();

    }

    @Override
    public synchronized String getNumberEmptyRoomInHotel() {

        return roomManager.getNumberEmptyRoomInHotel().toString();

    }

    @Override
    public synchronized String getListOfServices() {
        return textWorker.createServiceList(serviceManager.getServices());
    }

    @Override
    public synchronized String getListLeftGuestThisRoom(String numberOfRoom) {
        try {
            return textWorker.createGuestList(historyManager.getListLeftGuestThisRoom(roomManager.getRoom(getRoomNumberByNumberOnList(Integer.parseInt(numberOfRoom))), configuration.getNumberRecordsGuests()));
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
            return null;
        }
    }

    @Override
    public synchronized String getDetailsOfRoom(String numberOfRoom) {
        try {
            return textWorker.createRoomList(roomManager.getDetailsOfRoom(getRoomNumberByNumberOnList(Integer.parseInt(numberOfRoom))), null);

        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
            return null;
        }
    }

    @Override
    public synchronized String getSortRoomsByCapacity() {
        roomManager.sorting(new RoomComparator().getCapacityComparator());
        return textWorker.createRoomList(roomManager.getRooms(), null);

    }

    @Override
    public synchronized String getSortRoomsByPrice() {
        roomManager.sorting(new RoomComparator().getPriceComparator());
        return textWorker.createRoomList(roomManager.getRooms(), null);
    }

    @Override
    public synchronized String getSortRoomsByNumberOfStars() {
        roomManager.sorting(new RoomComparator().getNumberStarsComparator());
        return textWorker.createRoomList(roomManager.getRooms(), null);
    }

    @Override
    public synchronized String getSortEmptyRoomsByCapacity() {

        roomManager.sorting(new RoomComparator().getBusyComparator(), new RoomComparator().getCapacityComparator());
        return textWorker.createRoomList(roomManager.getRooms(), roomManager.getNumberEmptyRoomInHotel());
    }

    @Override
    public synchronized String getSortEmptyRoomsByPrice() {
        roomManager.sorting(new RoomComparator().getBusyComparator(), new RoomComparator().getPriceComparator());
        return textWorker.createRoomList(roomManager.getRooms(), roomManager.getNumberEmptyRoomInHotel());

    }

    @Override
    public synchronized String getSortEmptyRoomsByNumberOfStars() {
        roomManager.sorting(new RoomComparator().getBusyComparator(), new RoomComparator().getNumberStarsComparator());
        return textWorker.createRoomList(roomManager.getRooms(), roomManager.getNumberEmptyRoomInHotel());

    }

    @Override
    public synchronized String getSortGuestByDateOfDeparture() {
        guestManager.sorting(new GuestComparator().getDateComparator());
        return textWorker.createGuestList(guestManager.getGuests());

    }

    @Override
    public synchronized String getSortListServiceGuestByPrice(String guestId, String numberRoom) {
        historyManager.sorting(guestManager.getGuestByID(getGuestIdByNumberOnList(Integer.parseInt(guestId))), new ServiceComparator().getServiceByPriceComparator(), roomManager.getRoom(getRoomNumberByNumberOnList(Integer.parseInt(numberRoom))));
        return textWorker.createServiceList(historyManager.getGuestServices(guestManager.getGuestByID(getGuestIdByNumberOnList(Integer.parseInt(guestId))), roomManager.getRoom(getRoomNumberByNumberOnList(Integer.parseInt(numberRoom)))));
    }

    @Override
    public synchronized String getSortListServiceGuestByCategory(String guestId, String numberRoom) {

        historyManager.sorting(guestManager.getGuestByID(getGuestIdByNumberOnList(Integer.parseInt(guestId))), new ServiceComparator().getServiceByCategoryComparator(), roomManager.getRoom(getRoomNumberByNumberOnList(Integer.parseInt(numberRoom))));
        return textWorker.createServiceList(historyManager.getGuestServices(guestManager.getGuestByID(getGuestIdByNumberOnList(Integer.parseInt(guestId))), roomManager.getRoom(getRoomNumberByNumberOnList(Integer.parseInt(numberRoom)))));
    }

    @Override
    public synchronized String getSortGuestByName() {
        guestManager.sorting(new GuestComparator().getNameComparator());
        return textWorker.createGuestList(guestManager.getGuests());
    }
}
