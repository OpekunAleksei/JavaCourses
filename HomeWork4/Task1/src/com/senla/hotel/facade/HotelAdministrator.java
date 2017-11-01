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
import com.senla.hotel.utils.FileWorker;

import java.text.ParseException;
import java.util.Date;

public class HotelAdministrator {

    private GuestManager guestManager;
    private RoomManager roomManager;
    private ServiceManager serviceManager;
    private HistoryManager historyManager;
    private FileWorker fileWorker;
    

    public HotelAdministrator(String roomPath, String guestPath, String servicePath) {
        roomManager = new RoomManager(roomPath);
        guestManager = new GuestManager(guestPath);
        serviceManager = new ServiceManager(servicePath);
        historyManager = new HistoryManager();
              
    }

    public HotelAdministrator() {
         fileWorker= new FileWorker();
    }

    public String getGuestPriceForAccommodation(Integer guestId) {
        return historyManager.getGuestPriceForAccommodation(guestManager.getGuest(guestId)).toString();
    }

    public void createRoom() {
        roomManager.createRoom();
    }

    public void createGuest() throws ParseException {
        guestManager.createGuest();
    }

    public void createService() {
        serviceManager.createService();
    }
public void writeToGuestFile(String path,String[] array){
    fileWorker.writeToGuestFile(path,array);
}
public void writeToRoomFile(String path,String[] array){
    fileWorker.writeToRoomFile(path,array);
}
public void writeToServiceFile(String path,String[] array){
    fileWorker.writeToServiceFile(path,array);
}
    public void changeRoomPrice(Integer numberOfRoom, Integer price) {
        roomManager.changeRoomPrice(numberOfRoom, price);
    }

    public void changeServicePrice(String serviceCategory, Integer price) {
        serviceManager.changeServicePrice(serviceCategory, price);
    }

    public String getListOfRoomsAvailableByDate(Date date) {
        return historyManager.getListOfRoomsAvailableByDate(date);
    }

    public void changeRoomStatus(Integer numberOfRoom, RoomStatus status) {
        roomManager.changeRoomStatus(numberOfRoom, status);
    }

    public void addServiceToGuest(Integer serviceId, Integer guestId) {
        historyManager.addServiceToGuest(serviceManager.getService(serviceId), guestManager.getGuest(guestId));
    }

    public void settleInRoom(Integer guestId, Integer numberOfRoom) throws ParseException {
        roomManager.changeRoomBusy(numberOfRoom, Boolean.TRUE);
        historyManager.settleInRoom(guestManager.getGuest(guestId), roomManager.getRoom(numberOfRoom));
    }

    public void evictedFromRoom(Integer guestId, Integer numberOfRoom) throws ParseException {
        historyManager.evictedFromRoom(guestManager.getGuest(guestId));
        if (historyManager.checkForPresenceGuestsInRoom(roomManager.getRoom(numberOfRoom)) == true) {
            roomManager.changeRoomBusy(numberOfRoom, Boolean.FALSE);
        }
    }

    public String getNumberGuestInHotel() {
        return historyManager.getNumberGuestInHotel().toString();
    }

    public String getNumberEmptyRoomInHotel() {
        return roomManager.getNumberEmptyRoomInHotel().toString();
    }

    public String getListLeftThreeGuestThisRoom(Integer numberOfRoom) throws ParseException {
        return historyManager.getListLeftThreeGuestThisRoom(roomManager.getRoom(numberOfRoom));
    }

    public String getDetailsOfRoom(Integer numberOfRoom) {
        return roomManager.getDetailsOfRoom(numberOfRoom);
    }

    public String getSortRoomsByCapacity() {
        return roomManager.getSortRoomsByCapacity();
    }

    public String getSortRoomsByPrice() {
        return roomManager.getSortRoomsByPrice();
    }

    public String getSortRoomsByNumberOfStars() {
        return roomManager.getSortRoomsByNumberOfStars();
    }

    public String getSortEmptyRoomsByCapacity() {
        return roomManager.getSortEmptyRoomsByCapacity();
    }

    public String getSortEmptyRoomsByPrice() {
        return roomManager.getSortEmptyRoomsByPrice();
    }

    public String getSortEmptyRoomsByNumberOfStars() {
        return roomManager.getSortEmptyRoomsByNumberOfStars();
    }

    public String getSortGuestByDateOfDeparture() {
        return guestManager.getSortGuestByDateOfDeparture();
    }

    public String getSortListServiceGuestByPrice(Integer guestId) {
        return historyManager.getGuestSortServiceByPrice(guestManager.getGuest(guestId));
    }

    public String getSortListServiceGuestByCategory(Integer guestId) {
        return historyManager.getSortListServiceGuestByCategory(guestManager.getGuest(guestId));
    }

    public String getSortGuestByName() {
        return guestManager.getSortGuestByName();
    }
}
