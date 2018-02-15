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
import com.senla.hotel.configuration.Configuration;
import com.senla.hotel.entity.Guest;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;
import com.senla.hotel.factory.ManagerFactory;
import com.senla.hotel.csv.CsvWorker;
import com.senla.hotel.enums.SortName;
import com.senla.hotel.utils.DateConverter;

import com.senla.hotel.utils.DataParser;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Date;
import org.apache.log4j.Logger;

public class HotelAdministrator implements IHotelAdministrator {

    private final DataParser textWorker;
    private final IGuestManager guestManager;
    private final IRoomManager roomManager;
    private final IServiceManager serviceManager;
    private final IHistoryManager historyManager;
    private static Logger logger = Logger.getLogger(IHotelAdministrator.class);
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
        roomManager = (IRoomManager) managerFactory.getObject(IRoomManager.class);
        guestManager = (IGuestManager) managerFactory.getObject(IGuestManager.class);
        serviceManager = (IServiceManager) managerFactory.getObject(IServiceManager.class);
        historyManager = (IHistoryManager) managerFactory.getObject(IHistoryManager.class);
        csvWorker = new CsvWorker(configuration.getCsvPath());

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
        } catch (NumberFormatException e) {
            logger.error(new Date() + " " + e.getMessage());
            return null;
        }
    }

    public synchronized String getListOfRooms() {
        return textWorker.createRoomList(roomManager.getRooms(), null);
    }

    @Override
    public synchronized void changeNumberOfStars(String numberOfRoom, String numberOfStars) {
        roomManager.changeNumberOfStars((Integer.parseInt(numberOfRoom)), Integer.parseInt(numberOfStars));
    }

    @Override
    public synchronized void changeCapacity(String numberOfRoom, String capacity) {

        roomManager.changeCapacity((Integer.parseInt(numberOfRoom)), Integer.parseInt(capacity));
    }

    @Override
    public synchronized void createRoom(String number, String price, String capacity, String numberOfStars, String status) {
        try {
            roomManager.createRoom(Integer.parseInt(number), Integer.parseInt(price), Integer.parseInt(capacity), Integer.parseInt(numberOfStars), dataParser.getRoomStatus(status));
        } catch (NumberFormatException e) {
            logger.error(new Date() + " " + e.getMessage());
        }
    }

    @Override
    public synchronized void copyRoom(String numberOfRoom, String newNumber) {

        roomManager.copyRoom(getRoomNumberByNumberOnList(Integer.parseInt(numberOfRoom)), Integer.parseInt(newNumber));

    }

    @Override
    public synchronized void createGuest(String name, String arrivalDate, String dateOfDeparture) {
        try {

            guestManager.createGuest(name, dateConverter.parseDate(arrivalDate), dateConverter.parseDate(dateOfDeparture));
        } catch (ParseException e) {
            logger.error(new Date() + " " + e.getMessage());

        }
    }

    @Override
    public synchronized void importRooms() {

        try {
            roomManager.setImportRooms(csvWorker.importData(Room.class));

        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ParseException e) {
            logger.error(new Date() + " " + e.getMessage());
        }

    }

    @Override
    public synchronized void exportRooms() {

        try {
            csvWorker.exportData(roomManager.getRooms());
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | IOException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public synchronized void importServices() {

        try {
            serviceManager.setImportServices(csvWorker.importData(Service.class));
        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ParseException e) {
            logger.error(new Date() + " " + e.getMessage());
        }

    }

    @Override
    public synchronized void exportServices() {

        try {
            csvWorker.exportData(serviceManager.getServices());
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | IOException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }

    }

    @Override
    public synchronized void importGuests() {

        try {
            guestManager.setImpotrGuests(csvWorker.importData(Guest.class));
        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ParseException e) {
            logger.error(new Date() + " " + e.getMessage());
        }

    }

    @Override
    public synchronized void exportGuests() {

        try {
            csvWorker.exportData(guestManager.getListOfGuest(SortName.zero.toString()));
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | IOException e) {
            logger.error(new Date() + " " + e.getMessage());
        }

    }

    @Override
    public synchronized Integer getGuestIdByNumberOnList(Integer number) {
        try {
            return guestManager.getIdByNumberOnList(number);
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
        }
        return null;
    }

    @Override
    public synchronized Integer getRoomNumberByNumberOnList(Integer number) {
        try {
            return roomManager.getIdByNumberOnList(number);
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
        }
        return null;
    }

    @Override
    public synchronized Integer getServiceIdByNumberOnList(Integer number) {
        try {
            return serviceManager.getIdByNumberOnList(number);
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
        }
        return null;
    }

    @Override
    public synchronized void createService(String price, String category) {
        try {
            serviceManager.createService(Integer.parseInt(price), category);
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());

        }
    }

    @Override
    public synchronized void changeRoomPrice(String numberOfRoom, String price) {
        try {

            roomManager.changeRoomPrice(getRoomNumberByNumberOnList(Integer.parseInt(numberOfRoom)), Integer.parseInt(price));
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
        }
    }

    @Override
    public synchronized void changeServicePrice(String serviceId, String price) {
        try {
            serviceManager.changeServicePrice(getServiceIdByNumberOnList(Integer.parseInt(serviceId)), Integer.parseInt(price));
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
        }
    }

    @Override
    public synchronized String getListOfRoomsAvailableByDate(String date) {
        try {

            return textWorker.createRoomList(historyManager.getListOfRoomsAvailableByDate(dateConverter.parseDate(date), roomManager.getRooms()), null);
        } catch (ParseException e) {
            logger.error(new Date() + " " + e.getMessage());

            return null;
        }
    }

    @Override
    public synchronized String getRoomAbility() {

        return configuration.getAbilityChangeRoomStatus().toString();
    }

    @Override
    public synchronized void changeRoomStatus(String numberOfRoom, String status) {
        try {
            roomManager.changeRoomStatus(getRoomNumberByNumberOnList(Integer.parseInt(numberOfRoom)), dataParser.getRoomStatus(status));
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
        }
    }

    @Override
    public synchronized void addServiceToGuest(String serviceId, String guestId, String numberRoom) {
        try {

            historyManager.addServiceToGuest(serviceManager.getService(getServiceIdByNumberOnList(Integer.parseInt(serviceId))), guestManager.getGuestByID(getGuestIdByNumberOnList(Integer.parseInt(guestId))), roomManager.getRoom(getRoomNumberByNumberOnList(Integer.parseInt(numberRoom))));
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
        }
    }

    @Override
    public synchronized void settleInRoom(String guestId, String numberOfRoom) {
        try {
           
            historyManager.settleInRoom(guestManager.getGuestByID(getGuestIdByNumberOnList(Integer.parseInt(guestId))), roomManager.getRoom(getRoomNumberByNumberOnList(Integer.parseInt(numberOfRoom))),roomManager);
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
        }
    }

    @Override
    public synchronized void evictedFromRoom(String guestId, String numberOfRoom) {
        try {
           
            historyManager.evictedFromRoom(guestManager.getGuestByID(getGuestIdByNumberOnList(Integer.parseInt(guestId))), roomManager.getRoom(getRoomNumberByNumberOnList(Integer.parseInt(numberOfRoom))),roomManager);

        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
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
            logger.error(new Date() + " " + e.getMessage());
            return null;
        }
    }

    @Override
    public synchronized String getDetailsOfRoom(String numberOfRoom) {
        try {
            return textWorker.createRoomList(roomManager.getDetailsOfRoom(getRoomNumberByNumberOnList(Integer.parseInt(numberOfRoom))), null);

        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
            return null;
        }
    }

    @Override
    public synchronized String getListServiceOfGuest(String guestId, String numberRoom, String name) {
        return textWorker.createServiceList(historyManager.getGuestServices(guestManager.getGuestByID(getGuestIdByNumberOnList(Integer.parseInt(guestId))), roomManager.getRoom(getRoomNumberByNumberOnList(Integer.parseInt(numberRoom))), name));
    }

    @Override
    public synchronized String getListOfRooms(String name, String busy) {
        return textWorker.createRoomList(roomManager.getListRooms(name, busy), null);
    }

    @Override
    public synchronized String getListGuest(String name) {
        return textWorker.createGuestList(guestManager.getListOfGuest(name));
    }
}
