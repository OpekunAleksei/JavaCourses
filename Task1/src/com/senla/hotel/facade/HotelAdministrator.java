/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.facade;

import com.senla.hotel.managers.ServiceManager;
import com.senla.hotel.managers.RoomManager;
import com.senla.hotel.managers.HistoryManager;
import com.senla.hotel.managers.GuestManager;
import com.senla.hotel.enums.RoomStatus;
import com.senla.hotel.utils.Logger;
import java.text.ParseException;
import java.util.Date;

public class HotelAdministrator {

    private GuestManager guestManager;
    private RoomManager roomManager;
    private ServiceManager serviceManager;
    private HistoryManager historyManager;
    private Logger logger;

    public HotelAdministrator(String roomPath, String guestPath, String servicePath) {
        roomManager = new RoomManager(roomPath);
        guestManager = new GuestManager(guestPath);
        serviceManager = new ServiceManager(servicePath);
        historyManager = new HistoryManager();
        logger = new Logger();
    }

    public String getGuestPriceForAccommodation(Integer guestId) {
        try {
            return historyManager.getGuestPriceForAccommodation(guestManager.getGuest(guestId)).toString();
        } catch (Exception e) {
            logger.writeErrToFile(e);
            return null;
        }
    }

    public void createRoom() {
        try {
            roomManager.createRoom();
        } catch (Exception e) {
            logger.writeErrToFile(e);
        }
    }

    public void createGuest() throws ParseException {
        try {
            guestManager.createGuest();
        } catch (Exception e) {
            logger.writeErrToFile(e);

        }
    }

    public void createService() {
        serviceManager.createService();
    }

    public void writeToGuestFile(String[] array) {
        guestManager.writeToGuestFile(array);
    }

    public void writeToRoomFile(String[] array) {
        roomManager.writeToRoomFile(array);
    }

    public void writeToServiceFile(String[] array) {
        serviceManager.writeToServiceFile(array);
    }

    public void changeRoomPrice(Integer numberOfRoom, Integer price) {
        try {
            roomManager.changeRoomPrice(numberOfRoom, price);
        } catch (Exception e) {
            logger.writeErrToFile(e);
        }
    }

    public void changeServicePrice(String serviceCategory, Integer price) {
        try {
            serviceManager.changeServicePrice(serviceCategory, price);
        } catch (Exception e) {
            logger.writeErrToFile(e);
        }
    }

    public String getListOfRoomsAvailableByDate(Date date) {
        try {
            return historyManager.getListOfRoomsAvailableByDate(date);
        } catch (Exception e) {
            logger.writeErrToFile(e);
            return null;
        }
    }

    public void changeRoomStatus(Integer numberOfRoom, RoomStatus status) {
        try {
            roomManager.changeRoomStatus(numberOfRoom, status);
        } catch (Exception e) {
            logger.writeErrToFile(e);
        }
    }

    public void addServiceToGuest(Integer serviceId, Integer guestId) {
        try {
            historyManager.addServiceToGuest(serviceManager.getService(serviceId), guestManager.getGuest(guestId));
        } catch (Exception e) {
            logger.writeErrToFile(e);
        }
    }

    public void settleInRoom(Integer guestId, Integer numberOfRoom) throws ParseException {
        try {
            roomManager.changeRoomBusy(numberOfRoom, Boolean.TRUE);
            historyManager.settleInRoom(guestManager.getGuest(guestId), roomManager.getRoom(numberOfRoom));
        } catch (Exception e) {
            logger.writeErrToFile(e);
        }
    }

    public void evictedFromRoom(Integer guestId, Integer numberOfRoom) throws ParseException {
        try {
            historyManager.evictedFromRoom(guestManager.getGuest(guestId));
            if (historyManager.checkForPresenceGuestsInRoom(roomManager.getRoom(numberOfRoom)) == true) {
                roomManager.changeRoomBusy(numberOfRoom, Boolean.FALSE);
            }
        } catch (Exception e) {
            logger.writeErrToFile(e);
        }

    }

    public String getNumberGuestInHotel() {
        try {
            return historyManager.getNumberGuestInHotel().toString();
        } catch (Exception e) {
            logger.writeErrToFile(e);
            return null;
        }
    }

    public String getNumberEmptyRoomInHotel() {
        try {

            return roomManager.getNumberEmptyRoomInHotel().toString();
        } catch (Exception e) {
            logger.writeErrToFile(e);
            return null;
        }
    }

    public String getListLeftThreeGuestThisRoom(Integer numberOfRoom) throws ParseException {
        try {

            return historyManager.getListLeftThreeGuestThisRoom(roomManager.getRoom(numberOfRoom));
        } catch (Exception e) {
            logger.writeErrToFile(e);
            return null;
        }
    }

    public String getDetailsOfRoom(Integer numberOfRoom) {
        try {

            return roomManager.getDetailsOfRoom(numberOfRoom);
        } catch (Exception e) {
            logger.writeErrToFile(e);
            return null;
        }
    }

    public String getSortRoomsByCapacity() {
        try {

            return roomManager.getSortRoomsByCapacity();
        } catch (Exception e) {
            logger.writeErrToFile(e);
            return null;
        }
    }

    public String getSortRoomsByPrice() {
        try {

            return roomManager.getSortRoomsByPrice();
        } catch (Exception e) {
            logger.writeErrToFile(e);
            return null;
        }
    }

    public String getSortRoomsByNumberOfStars() {
        try {

            return roomManager.getSortRoomsByNumberOfStars();
        } catch (Exception e) {
            logger.writeErrToFile(e);
            return null;
        }
    }

    public String getSortEmptyRoomsByCapacity() {
        try {

            return roomManager.getSortEmptyRoomsByCapacity();
        } catch (Exception e) {
            logger.writeErrToFile(e);
            return null;
        }
    }

    public String getSortEmptyRoomsByPrice() {
        try {

            return roomManager.getSortEmptyRoomsByPrice();
        } catch (Exception e) {
            logger.writeErrToFile(e);
            return null;
        }
    }

    public String getSortEmptyRoomsByNumberOfStars() {
        try {
            return roomManager.getSortEmptyRoomsByNumberOfStars();
        } catch (Exception e) {
            logger.writeErrToFile(e);
            return null;
        }
    }

    public String getSortGuestByDateOfDeparture() {
        try {
            return guestManager.getSortGuestByDateOfDeparture();
        } catch (Exception e) {
            logger.writeErrToFile(e);
            return null;
        }
    }

    public String getSortListServiceGuestByPrice(Integer guestId) {
        try {
            return historyManager.getGuestSortServiceByPrice(guestManager.getGuest(guestId));
        } catch (Exception e) {
            logger.writeErrToFile(e);
            return null;
        }
    }

    public String getSortListServiceGuestByCategory(Integer guestId) {
        try {
            return historyManager.getSortListServiceGuestByCategory(guestManager.getGuest(guestId));
        } catch (Exception e) {
            logger.writeErrToFile(e);
            return null;
        }
    }

    public String getSortGuestByName() {
        try {
            return guestManager.getSortGuestByName();
        } catch (Exception e) {
            logger.writeErrToFile(e);
            return null;
        }
    }
}
