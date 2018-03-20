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
import com.senla.hotel.enums.SortName;
import com.senla.hotel.utils.DateConverter;
import com.senla.hotel.utils.DataParser;
import com.senla.hotel.utils.Transfer;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Arrays;
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
    private final IClientManager clientManager;
    private final Transfer transfer;

    private HotelAdministrator() {
        configuration = new Configuration();
        managerFactory = new ManagerFactory(configuration.getInjectProperties());
        textWorker = new DataParser();
        dateConverter = new DateConverter();
        clientManager = (IClientManager) managerFactory.getObject(IClientManager.class);
        roomManager = (IRoomManager) managerFactory.getObject(IRoomManager.class);
        guestManager = (IGuestManager) managerFactory.getObject(IGuestManager.class);
        serviceManager = (IServiceManager) managerFactory.getObject(IServiceManager.class);
        historyManager = (IHistoryManager) managerFactory.getObject(IHistoryManager.class);
        csvWorker = new CsvWorker(configuration.getCsvPath());
        transfer = new Transfer(configuration.getAuditPath());
    }

    public static IHotelAdministrator getInstance() {
        if (hotelAdministrator == null) {
            hotelAdministrator = new HotelAdministrator();
        }
        return hotelAdministrator;
    }

    @Override
    public synchronized void registerUser(String login, String password, String information) {
        try {
            clientManager.registerUser(login, password);
            transfer.auditUserAction(information);
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public synchronized void signOut(String login, String password, String information) {
        try {
            clientManager.signOut(login, password);
            transfer.auditUserAction(information);
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public synchronized String getToken(String login, String password) {
        try {
            return clientManager.getToken(login, password);
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
        return null;
    }

    @Override
    public synchronized void signIn(String login, String password, String token, String information) {
        try {
            clientManager.signIn(login, password, token);
            transfer.auditUserAction(information);
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
        }
    }

    @Override
    public synchronized String getGuestPriceForAccommodation(Integer guestId, Integer numberRoom, String information) {
        try {
            transfer.auditUserAction(information);
            return historyManager.getGuestPriceForAccommodation(guestManager.getGuestByID(getGuestIdByNumberOnList(guestId)), roomManager.getRoom(getRoomNumberByNumberOnList(numberRoom))).toString();
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
            return null;
        }
    }

    public synchronized String getListOfRooms(String information) {
        try {
            transfer.auditUserAction(information);
            return textWorker.createRoomList(roomManager.getRooms(), null);
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
        return null;
    }

    @Override
    public synchronized void changeNumberOfStars(Integer numberOfRoom, Integer numberOfStars, String information) {
        try {
            transfer.auditUserAction(information);
            roomManager.changeNumberOfStars(numberOfRoom, numberOfStars);
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public synchronized void changeCapacity(Integer numberOfRoom, Integer capacity, String information) {

        try {
            transfer.auditUserAction(information);
            roomManager.changeCapacity(numberOfRoom, capacity);
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public synchronized void createRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, String status, String information) {
        try {
            transfer.auditUserAction(information);
            roomManager.createRoom(number, price, capacity, numberOfStars, status);
        } catch (NumberFormatException e) {
            logger.error(new Date() + " " + e.getMessage());
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public synchronized void copyRoom(Integer numberOfRoom, Integer newNumber, String information) {
        try {
            transfer.auditUserAction(information);
            roomManager.copyRoom(getRoomNumberByNumberOnList(numberOfRoom), newNumber);
        } catch (CloneNotSupportedException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }

    }

    @Override
    public synchronized void createGuest(String name, String arrivalDate, String dateOfDeparture, String information) {
        try {
            transfer.auditUserAction(information);
            guestManager.createGuest(name, dateConverter.parseDate(arrivalDate), dateConverter.parseDate(dateOfDeparture));
        } catch (ParseException e) {
            logger.error(new Date() + " " + e.getMessage());

        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public synchronized void importRooms(String information) {

        try {
            roomManager.setImportRooms(csvWorker.importData(Room.class));
            transfer.auditUserAction(information);
        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ParseException e) {
            logger.error(new Date() + " " + e.getMessage());
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }

    }

    @Override
    public synchronized void exportRooms(String information) {

        try {
            transfer.auditUserAction(information);
            csvWorker.exportData(roomManager.getRooms());
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | IOException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public synchronized void importServices(String information) {

        try {
            transfer.auditUserAction(information);
            serviceManager.setImportServices(csvWorker.importData(Service.class));
        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ParseException e) {
            logger.error(new Date() + " " + e.getMessage());
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }

    }

    @Override
    public synchronized void exportServices(String information) {

        try {
            transfer.auditUserAction(information);
            csvWorker.exportData(serviceManager.getServices());
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | IOException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }

    }

    @Override
    public synchronized void importGuests(String information) {

        try {
            transfer.auditUserAction(information);
            guestManager.setImpotrGuests(csvWorker.importData(Guest.class));
        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ParseException e) {
            logger.error(new Date() + " " + e.getMessage());
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }

    }

    @Override
    public synchronized void exportGuests(String information) {

        try {
            transfer.auditUserAction(information);
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
    public synchronized void createService(Integer price, String category, String information) {
        try {
            transfer.auditUserAction(information);
            serviceManager.createService(price, category);
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());

        }
    }

    @Override
    public synchronized void changeRoomPrice(Integer numberOfRoom, Integer price, String information) {
        try {
            transfer.auditUserAction(information);
            roomManager.changeRoomPrice(getRoomNumberByNumberOnList(numberOfRoom), price);
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
        }
    }

    @Override
    public synchronized void changeServicePrice(Integer serviceId, Integer price, String information) {
        try {
            transfer.auditUserAction(information);
            serviceManager.changeServicePrice(getServiceIdByNumberOnList(serviceId), price);
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
        }
    }

    @Override
    public synchronized String getListOfRoomsAvailableByDate(String date, String information) {
        try {
            transfer.auditUserAction(information);
            return textWorker.createRoomList(historyManager.getListOfRoomsAvailableByDate(dateConverter.parseDate(date)), null);
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());

            return null;
        }
    }

    private synchronized String getRoomAbility() {
        return configuration.getAbilityChangeRoomStatus().toString();
    }

    @Override
    public synchronized void changeRoomStatus(Integer numberOfRoom, String status, String information) {
        try {
            transfer.auditUserAction(information);
            roomManager.changeRoomStatus(getRoomNumberByNumberOnList(numberOfRoom), status);
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
        }
    }

    @Override
    public synchronized void addServiceToGuest(Integer serviceId, Integer guestId, Integer numberRoom, String information) {
        try {
            transfer.auditUserAction(information);
            historyManager.addServiceToGuest(serviceManager.getService(getServiceIdByNumberOnList(serviceId)), guestManager.getGuestByID(getGuestIdByNumberOnList(guestId)), roomManager.getRoom(getRoomNumberByNumberOnList(numberRoom)));
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
        }
    }

    @Override
    public synchronized void settleInRoom(Integer guestId, Integer numberOfRoom, String information) {
        try {
            transfer.auditUserAction(information);
            historyManager.settleInRoom(guestManager.getGuestByID(getGuestIdByNumberOnList(guestId)), roomManager.getRoom(getRoomNumberByNumberOnList(numberOfRoom)));
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
        }
    }

    @Override
    public synchronized void evictedFromRoom(Integer guestId, Integer numberOfRoom, String information) {
        try {
            transfer.auditUserAction(information);
            historyManager.evictedFromRoom(guestManager.getGuestByID(getGuestIdByNumberOnList(guestId)), roomManager.getRoom(getRoomNumberByNumberOnList(numberOfRoom)));
        } catch (Exception e) {

            logger.error(new Date() + " " + Arrays.toString(e.getStackTrace()));
        }

    }

    @Override
    public synchronized String getNumberGuestInHotel(String information) {

        try {
            transfer.auditUserAction(information);
            return historyManager.getNumberGuestInHotel().toString();
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
        return null;

    }

    @Override
    public synchronized String getNumberEmptyRoomInHotel(String information) {

        try {
            transfer.auditUserAction(information);
            return roomManager.getNumberEmptyRoomInHotel().toString();
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
        return null;

    }

    @Override
    public synchronized String getListOfServices(String information) {
        try {
            transfer.auditUserAction(information);
            return textWorker.createServiceList(serviceManager.getServices());
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
        return null;
    }

    @Override
    public synchronized String getListLeftGuestThisRoom(Integer numberOfRoom, String information) {
        try {
            transfer.auditUserAction(information);
            return textWorker.createGuestList(historyManager.getListLeftGuestThisRoom(roomManager.getRoom(getRoomNumberByNumberOnList(numberOfRoom)), configuration.getNumberRecordsGuests()));
        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
            return null;
        }
    }

    @Override
    public synchronized String getDetailsOfRoom(Integer numberOfRoom, String information) {
        try {
            transfer.auditUserAction(information);
            return textWorker.createRoomList(roomManager.getDetailsOfRoom(getRoomNumberByNumberOnList(numberOfRoom)), null);

        } catch (Exception e) {
            logger.error(new Date() + " " + e.getMessage());
            return null;
        }
    }

    @Override
    public synchronized String getListServiceOfGuest(Integer guestId, Integer numberRoom, String name, String information) {
        try {
            transfer.auditUserAction(information);
            return textWorker.createServiceList(historyManager.getGuestServices(guestManager.getGuestByID(getGuestIdByNumberOnList(guestId)), roomManager.getRoom(getRoomNumberByNumberOnList(numberRoom)), name));
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
        return null;
    }

    @Override
    public synchronized String getListOfRooms(String name, Boolean busy, String information) {
        try {
            transfer.auditUserAction(information);
            return textWorker.createRoomList(roomManager.getListRooms(name, busy), null);
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
        return null;
    }

    @Override
    public synchronized String getListGuest(String name, String information) {
        try {
            transfer.auditUserAction(information);
            return textWorker.createGuestList(guestManager.getListOfGuest(name));
        } catch (Exception ex) {
            logger.error(new Date() + " " + Arrays.toString(ex.getStackTrace()));
        }
        return null;
    }

}
