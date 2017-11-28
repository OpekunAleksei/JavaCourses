/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.facade;

import com.senla.hotel.comparators.GuestComparator;
import com.senla.hotel.comparators.RoomComparator;
import com.senla.hotel.comparators.ServiceComparator;
import com.senla.hotel.managers.ServiceManager;
import com.senla.hotel.managers.RoomManager;
import com.senla.hotel.managers.HistoryManager;
import com.senla.hotel.managers.GuestManager;
import com.senla.hotel.enums.RoomStatus;
import com.senla.hotel.storages.StoragePropertys;
import com.senla.hotel.utils.DateConverter;
import com.senla.hotel.utils.Logger;
import com.senla.hotel.utils.Printer;
import java.io.IOException;
import java.text.ParseException;

public class HotelAdministrator {

    private final GuestManager guestManager;
    private final RoomManager roomManager;
    private final ServiceManager serviceManager;
    private final HistoryManager historyManager;
    private final Logger logger;
    private final DateConverter dateConverter;
    private static HotelAdministrator hotelAdministrator;
    private static StoragePropertys storagePropertys;
    private final Printer printer;

    private HotelAdministrator() {
        dateConverter = new DateConverter();
        storagePropertys = new StoragePropertys();
        logger = new Logger();
        roomManager = new RoomManager(storagePropertys.getRoomPath());
        guestManager = new GuestManager(storagePropertys.getGuestPath());
        serviceManager = new ServiceManager(storagePropertys.getServicePath());
        historyManager = new HistoryManager(storagePropertys.getHistoryPath());
        printer = new Printer();
        readData();
    }

    public static HotelAdministrator getInstance() {
        if (hotelAdministrator == null) {
            hotelAdministrator = new HotelAdministrator();
        }
        return hotelAdministrator;
    }

    public String getGuestPriceForAccommodation(Integer guestId, Integer numberRoom) {
        try {
            return historyManager.getGuestPriceForAccommodation(guestManager.getGuestByID(guestId), roomManager.getRoom(numberRoom)).toString();
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
            return null;
        }
    }



    public void changeNumberOfStars(Integer numberOfRoom, Integer numberOfStars) {
        roomManager.changeNumberOfStars(numberOfRoom, numberOfStars);
    }

    public void changeCapacity(Integer numberOfRoom, Integer capacity) {
        roomManager.changeCapacity(numberOfRoom, capacity);
    }

    public void writeData() {
        guestManager.serializeData();
        roomManager.serializeData();
        historyManager.serializeData();
        serviceManager.serializeData();
    }

    public void createRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, Integer id, RoomStatus status) {
        try {
            roomManager.createRoom(number, price, capacity, numberOfStars, id, status);
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry data", e);
        }
    }

    public void copyRoom(Integer numberOfRoom, Integer newId, Integer newNumber) {
        try {
            roomManager.copyRoom(numberOfRoom, newId, newNumber);
        } catch (CloneNotSupportedException e) {
            logger.writeErrToFile("Wrong entry data", e);
        }
    }

    public void createGuest(String name, String arrivalDate, String dateOfDeparture, Integer id) {
        try {
            guestManager.createGuest(name, dateConverter.getDateFormat().parse(arrivalDate), dateConverter.getDateFormat().parse(dateOfDeparture), id);
        } catch (ParseException e) {
            logger.writeErrToFile("Wrong entry date", e);

        }
    }
       public void importRooms(String path) {
        try {
            roomManager.importRooms(path);
        } catch (IOException e) {
            logger.writeErrToFile("Wrong path to file", e);
        }
    }
    public void exportRooms(String path) {
        try {
            roomManager.exportRooms(path);
        } catch (IOException ex) {
            logger.writeErrToFile("Check path to file", ex);
        }

    }
       public void importServices(String path) {
        try {
            serviceManager.importServices(path);
        } catch (IOException e) {
            logger.writeErrToFile("Wrong path to file", e);
        } 

    }
    public void exportServices(String path) {
        try {
            serviceManager.exportServices(path);
        } catch (IOException ex) {
            logger.writeErrToFile("Check path to file", ex);
        }

    }
    public void importGuests(String path) {
        try {
            guestManager.importGuests(path);
        } catch (IOException e) {
            logger.writeErrToFile("Wrong path to file", e);
        } catch (ParseException e) {
            logger.writeErrToFile("Wrong file input data ", e);
        }

    }
    public void exportGuests(String path) {
        try {
            guestManager.exportGuests(path);
        } catch (IOException ex) {
            logger.writeErrToFile("Check path to file", ex);
        }

    }

    public Integer getGuestIdByNumberOnList(Integer number) {
        try {
            return guestManager.getIdByNumberOnList(number);
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
        return null;
    }

    public Integer getRoomNumberByNumberOnList(Integer number) {
        try {
            return roomManager.getIdByNumberOnList(number);
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
        return null;
    }

    public Integer getServiceIdByNumberOnList(Integer number) {
        try {
            return serviceManager.getIdByNumberOnList(number);
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
        return null;
    }

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

    public void changeRoomPrice(Integer numberOfRoom, Integer price) {
        try {
            roomManager.changeRoomPrice(numberOfRoom, price);
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
    }

    public void changeServicePrice(Integer serviceId, Integer price) {
        try {
            serviceManager.changeServicePrice(serviceId, price);
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
    }

    public String getListOfRoomsAvailableByDate(String date) {
        try {
            return historyManager.getListOfRoomsAvailableByDate(dateConverter.getDateFormat().parse(date), roomManager.getRooms());
        } catch (ParseException e) {
            logger.writeErrToFile("Wrong entry date", e);

            return null;
        }
    }

    public Boolean getRoomAbility() {
        return storagePropertys.getAbility();
    }

    public void changeRoomStatus(Integer numberOfRoom, RoomStatus status) {

        try {
            roomManager.changeRoomStatus(numberOfRoom, status);
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
    }

    public void addServiceToGuest(Integer serviceId, Integer guestId, Integer numberRoom) {
        try {
            historyManager.addServiceToGuest(serviceManager.getService(serviceId), guestManager.getGuestByID(guestId), roomManager.getRoom(numberRoom));
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
    }

    public void settleInRoom(Integer guestId, Integer numberOfRoom) {
        try {
            roomManager.changeRoomBusy(numberOfRoom, Boolean.TRUE);
            historyManager.settleInRoom(guestManager.getGuestByID(guestId), roomManager.getRoom(numberOfRoom));
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
        }
    }

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

    public String getNumberGuestInHotel() {

        return historyManager.getNumberGuestInHotel().toString();

    }

    public String getNumberEmptyRoomInHotel() {

        return roomManager.getNumberEmptyRoomInHotel().toString();

    }

    public String getListOfServices() {
        return serviceManager.getListOfServices();
    }

    public String getListLeftGuestThisRoom(Integer numberOfRoom) {
        try {

            return historyManager.getListLeftGuestThisRoom(roomManager.getRoom(numberOfRoom), storagePropertys.getNumberLeftGuest());
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
            return null;
        }
    }

    public String getDetailsOfRoom(Integer numberOfRoom) {
        try {

            return roomManager.getDetailsOfRoom(numberOfRoom);
        } catch (Exception e) {
            logger.writeErrToFile("Wrong entry line number", e);
            return null;
        }
    }

    public String getSortRoomsByCapacity() {

        return roomManager.sorting(new RoomComparator().getCapacityComparator());

    }

    public String getSortRoomsByPrice() {
        return roomManager.sorting(new RoomComparator().getPriceComparator());
    }

    public String getSortRoomsByNumberOfStars() {

        return roomManager.sorting(new RoomComparator().getNumberStarsComparator());

    }

    public String getSortEmptyRoomsByCapacity() {

        return roomManager.sorting(new RoomComparator().getBusyComparator(), new RoomComparator().getCapacityComparator());

    }

    public String getSortEmptyRoomsByPrice() {

        return roomManager.sorting(new RoomComparator().getBusyComparator(), new RoomComparator().getPriceComparator());

    }

    public String getSortEmptyRoomsByNumberOfStars() {

        return roomManager.sorting(new RoomComparator().getBusyComparator(), new RoomComparator().getNumberStarsComparator());

    }

    public String getSortGuestByDateOfDeparture() {

        return guestManager.sorting(new GuestComparator().getDateComparator());

    }

    public String getSortListServiceGuestByPrice(Integer guestId, Integer numberRoom) {

        return historyManager.sorting(guestManager.getGuestByID(guestId), new ServiceComparator().getServiceByPriceComparator(), roomManager.getRoom(numberRoom));

    }

    public String getSortListServiceGuestByCategory(Integer guestId, Integer numberRoom) {

        return historyManager.sorting(guestManager.getGuestByID(guestId), new ServiceComparator().getServiceByCategoryComparator(), roomManager.getRoom(numberRoom));

    }

    public String getSortGuestByName() {

        return guestManager.sorting(new GuestComparator().getNameComparator());

    }
}
