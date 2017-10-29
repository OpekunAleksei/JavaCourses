/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grsy.ftf.lesson4task1.facade;

import by.grsy.ftf.lesson4task1.entity.Guest;
import by.grsy.ftf.lesson4task1.manager.GuestManager;
import by.grsy.ftf.lesson4task1.enumList.RoomStatus;
import by.grsy.ftf.lesson4task1.entity.Room;
import by.grsy.ftf.lesson4task1.manager.RoomManager;
import by.grsy.ftf.lesson4task1.manager.ServiceManager;
import by.grsy.ftf.lesson4task1.entity.Service;
import by.grsy.ftf.lesson4task1.manager.TableManager;
import java.text.ParseException;
import java.util.Date;

public class HotelAdministrator {

    private GuestManager guestManager;
    private RoomManager roomManager;
    private ServiceManager serviceManager;
    private TableManager tableManager;

    public HotelAdministrator() {
        roomManager = new RoomManager();
        guestManager = new GuestManager();
        serviceManager = new ServiceManager();
        tableManager = new TableManager();
    }

    public void createRoom(Room room) {
        roomManager.createRoom(room);
        tableManager.entryRoomToTable(roomManager.entryToTable());
    }

    public void createGuest(Guest guest) throws ParseException {
        guestManager.createGuest(guest);
    }

    public void createService(Service service) {
        serviceManager.createService(service);
    }

    public void changeRoomStatus(Room room, RoomStatus status) {
        roomManager.changeRoomStatus(room, status);
    }

    public void settleInRoom(Guest guest, Room room) throws ParseException {
        guestManager.setRoomNumber(guest, roomManager.getRoomNumber(room));
        roomManager.setDatesOfGuestStayAndBusy(room, guestManager.getGuest(guest).getArrivalDate(), guestManager.getGuest(guest).getDateOfDeparture());
        tableManager.entryGuestToTable(guestManager.getGuest(guest), room);
    }

    public String getNumberGuestInHotel() {
        return tableManager.getNumberGuestInHotel().toString();
    }

    public void changeRoomPrice(Room room, Integer price) {
        roomManager.changeRoomPrice(room, price);
    }

    public void changeServicePrice(Service service, Integer price) {
        serviceManager.changeServicePrice(service, price);
    }

    public void evictedFromRoom(Guest guest) throws ParseException {
        guestManager.setRoomNumber(guest, null);
        roomManager.setDatesOfGuestStayAndBusy(tableManager.getRoom(guestManager.getGuest(guest)), null, null);
        tableManager.evictedFromRoom(guestManager.getGuest(guest));
    }

    public String getDetailsOfRoom(Room room) {
        return roomManager.getDetailsOfRoom(room);
    }

    public void addServiceToGuest(Service service, Guest guest) {
        tableManager.addServiceToGuest(serviceManager.getService(service), guestManager.getGuest(guest));
    }

    public String getNumberEmptyRoomInHotel() {
        return tableManager.getNumberEmptyRoomInHotel().toString();
    }

    public String getListLeftThreeGuestThisRoom(Room room) {
        return tableManager.getListLeftGuestThisRoom(room);
    }

    public String getListOfRoomsAvailableByDate(Date date) {
        return tableManager.getListOfRoomsAvailableByDate(date);
    }

    public String getGuestPriceForAccommodation(Room room) {
        return tableManager.getGuestPriceForAccommodation(room).toString();
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

    public String getSortListServiceGuestByPrice(Guest guest) {
        return tableManager.getGuestSortServiceByPrice(guestManager.getGuest(guest));
    }

    public String getSortListServiceGuestByCategory(Guest guest) {
        return tableManager.getSortListServiceGuestByCategory(guestManager.getGuest(guest));
    }

    public String getSortGuestByName() {
        return guestManager.getSortGuestByName();
    }
}
