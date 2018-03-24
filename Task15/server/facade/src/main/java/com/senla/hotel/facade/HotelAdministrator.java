/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.facade;

import com.senla.hotel.api.facade.IHotelAdministrator;
import com.senla.hotel.api.managers.IClientManager;
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
import com.senla.hotel.entity.Client;
import com.senla.hotel.entity.utils.DateConverter;

import com.senla.hotel.enums.SortName;

import com.senla.hotel.utils.Transfer;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

public class HotelAdministrator implements IHotelAdministrator {

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
    private final IClientManager clientManager;
    private final Transfer transfer;

    private HotelAdministrator() {
        configuration = new Configuration();
        managerFactory = new ManagerFactory(configuration.getInjectProperties());
        dateConverter = new DateConverter();
        clientManager = (IClientManager) managerFactory.getObject(IClientManager.class);
        roomManager = (IRoomManager) managerFactory.getObject(IRoomManager.class);
        guestManager = (IGuestManager) managerFactory.getObject(IGuestManager.class);
        serviceManager = (IServiceManager) managerFactory.getObject(IServiceManager.class);
        historyManager = (IHistoryManager) managerFactory.getObject(IHistoryManager.class);
        csvWorker = new CsvWorker(configuration.getCsvPath());
        transfer = new Transfer(configuration.getAuditPath());
    }

    public synchronized static IHotelAdministrator getInstance() {
        if (hotelAdministrator == null) {
            hotelAdministrator = new HotelAdministrator();
        }
        return hotelAdministrator;
    }

    @Override
    public synchronized void auditData(Client user, String data) {

        try {
            transfer.auditUserAction(user, data);
        } catch (IOException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public synchronized void registerUser(String login, String password) {
        try {

            clientManager.registerUser(new Client(password.hashCode(), login));
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public synchronized void signOut(Client client) {
        try {
            clientManager.signOut(client);

        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public synchronized Client getClient(String login, String password) {
        try {
            return clientManager.getClient(login, password);
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
        return null;
    }

    @Override
    public synchronized void signIn(Client client, String token) {
        try {
            clientManager.signIn(client, token);

        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
        }
    }

    @Override
    public synchronized Long getGuestPriceForAccommodation(Integer guestId, Integer numberRoom) {
        try {

            return historyManager.getGuestPriceForAccommodation(guestManager.getGuestByID(getGuestIdByNumberOnList(guestId)), roomManager.getRoom(getRoomNumberByNumberOnList(numberRoom)));
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
            return null;
        }
    }

    public synchronized List getListOfRooms() {
        try {

            return roomManager.getRooms();
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
        return null;
    }

    @Override
    public synchronized void changeNumberOfStars(Integer numberOfRoom, Integer numberOfStars) {
        try {

            roomManager.changeNumberOfStars(numberOfRoom, numberOfStars);
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public synchronized void changeCapacity(Integer numberOfRoom, Integer capacity) {

        try {

            roomManager.changeCapacity(numberOfRoom, capacity);
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public synchronized void createRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, String status) {
        try {

            roomManager.createRoom(new Room(number, price, capacity, numberOfStars, status, false));
        } catch (NumberFormatException e) {
            logger.error(new Date() + " " + e.getMessage());
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public synchronized void copyRoom(Integer numberOfRoom, Integer newNumber) {
        try {

            roomManager.copyRoom(getRoomNumberByNumberOnList(numberOfRoom), newNumber);
        } catch (CloneNotSupportedException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }

    }

    @Override
    public synchronized void createGuest(String name, String arrivalDate, String dateOfDeparture) {
        try {

            guestManager.createGuest(new Guest(name, dateConverter.parseDate(arrivalDate), dateConverter.parseDate(dateOfDeparture)));
        } catch (ParseException e) {
            logger.error(new Date() + " " + e.getMessage());

        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public synchronized void importRooms() {

        try {
            roomManager.setImportRooms(csvWorker.importData(Room.class));

        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ParseException e) {
            logger.error(new Date() + " " + e.getMessage());
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }

    }

    @Override
    public synchronized void exportRooms() {

        try {
            csvWorker.exportData(roomManager.getRooms());
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | IOException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public synchronized void importServices() {

        try {

            serviceManager.setImportServices(csvWorker.importData(Service.class));
        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ParseException e) {
            logger.error(new Date() + " " + e.getMessage());
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }

    }

    @Override
    public synchronized void exportServices() {

        try {

            csvWorker.exportData(serviceManager.getServices());
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | IOException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }

    }

    @Override
    public synchronized void importGuests() {

        try {

            guestManager.setImpotrGuests(csvWorker.importData(Guest.class));
        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ParseException e) {
            logger.error(new Date() + " " + e.getMessage());
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }

    }

    @Override
    public synchronized void exportGuests() {

        try {

            csvWorker.exportData(guestManager.getListOfGuest(SortName.zero.toString()));
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | IOException e) {
            logger.error(new Date() + " " + e.getMessage());
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
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
    public synchronized void createService(Integer price, String category) {
        try {

            serviceManager.createService(new Service(price, category));
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());

        }
    }

    @Override
    public synchronized void changeRoomPrice(Integer numberOfRoom, Integer price) {
        try {

            roomManager.changeRoomPrice(getRoomNumberByNumberOnList(numberOfRoom), price);
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
        }
    }

    @Override
    public synchronized void changeServicePrice(Integer serviceId, Integer price) {
        try {

            serviceManager.changeServicePrice(getServiceIdByNumberOnList(serviceId), price);
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
        }
    }

    @Override
    public synchronized List getListOfRoomsAvailableByDate(String date) {
        try {

            return historyManager.getListOfRoomsAvailableByDate(dateConverter.parseDate(date));
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());

            return null;
        }
    }

    @Override
    public synchronized void changeRoomStatus(Integer numberOfRoom, String status) {
        try {

            roomManager.changeRoomStatus(getRoomNumberByNumberOnList(numberOfRoom), status);
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
        }
    }

    @Override
    public synchronized void addServiceToGuest(Integer serviceId, Integer guestId, Integer numberRoom) {
        try {

            historyManager.addServiceToGuest(serviceManager.getService(getServiceIdByNumberOnList(serviceId)), guestManager.getGuestByID(getGuestIdByNumberOnList(guestId)), roomManager.getRoom(getRoomNumberByNumberOnList(numberRoom)));
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
        }
    }

    @Override
    public synchronized void settleInRoom(Integer guestId, Integer numberOfRoom) {
        try {

            historyManager.settleInRoom(guestManager.getGuestByID(getGuestIdByNumberOnList(guestId)), roomManager.getRoom(getRoomNumberByNumberOnList(numberOfRoom)));
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
        }
    }

    @Override
    public synchronized void evictedFromRoom(Integer guestId, Integer numberOfRoom) {
        try {

            historyManager.evictedFromRoom(guestManager.getGuestByID(getGuestIdByNumberOnList(guestId)), roomManager.getRoom(getRoomNumberByNumberOnList(numberOfRoom)));
        } catch (Exception e) {

            logger.error(new Date() + " " + Arrays.toString(e.getStackTrace()));
        }

    }

    @Override
    public synchronized Integer getNumberGuestInHotel() {

        try {

            return historyManager.getNumberGuestInHotel();
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
        return null;

    }

    @Override
    public synchronized Integer getNumberEmptyRoomInHotel() {

        try {

            return roomManager.getNumberEmptyRoomInHotel();
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
        return null;

    }

    @Override
    public synchronized List getListOfServices() {
        try {

            return serviceManager.getServices();
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
        return null;
    }

    @Override
    public synchronized List getListLeftGuestThisRoom(Integer numberOfRoom) {
        try {

            return historyManager.getListLeftGuestThisRoom(roomManager.getRoom(getRoomNumberByNumberOnList(numberOfRoom)), configuration.getNumberRecordsGuests());
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
            return null;
        }
    }

    @Override
    public synchronized List getDetailsOfRoom(Integer numberOfRoom) {
        try {

            return roomManager.getDetailsOfRoom(getRoomNumberByNumberOnList(numberOfRoom));

        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
            return null;
        }
    }

    @Override
    public synchronized List getListServiceOfGuest(Integer guestId, Integer numberRoom, String name) {
        try {

            return historyManager.getGuestServices(guestManager.getGuestByID(getGuestIdByNumberOnList(guestId)), roomManager.getRoom(getRoomNumberByNumberOnList(numberRoom)), name);
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
        return null;
    }

    @Override
    public synchronized List getListOfRooms(String name, Boolean busy) {
        try {

            return roomManager.getListRooms(name, busy);
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
        return null;
    }

    @Override
    public synchronized List getListGuest(String name) {
        try {

            return guestManager.getListOfGuest(name);
        } catch (Exception ex) {
            logger.error(new Date() + " " + Arrays.toString(ex.getStackTrace()));
        }
        return null;
    }

}
