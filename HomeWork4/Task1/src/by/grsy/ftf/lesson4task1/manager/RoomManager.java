/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grsy.ftf.lesson4task1.manager;

import by.grsy.ftf.lesson4task1.entity.Room;
import by.grsy.ftf.lesson4task1.comparator.RoomComparator;
import by.grsy.ftf.lesson4task1.enumList.RoomStatus;
import by.grsy.ftf.lesson4task1.storage.RoomStorage;
import java.util.Arrays;
import java.util.Date;

public class RoomManager {
    private RoomStorage roomStorage;
    public RoomManager() {
        roomStorage = new RoomStorage();
    }

    public void createRoom(Room room) {
        roomStorage.setRoom(room);
    }

    public void changeRoomStatus(Room room, RoomStatus status) {
        roomStorage.changeRoomStatus(room, status);
    }

    public Integer getRoomNumber(Room room) {

        return roomStorage.getRoomId(room);
    }

    public String getDetailsOfRoom(Room room) {
        return roomStorage.getDetailsOfRoom(room);
    }

    public Room entryToTable() {

        return roomStorage.getRoom();
    }

    public void changeRoomPrice(Room room, Integer price) {
        roomStorage.changeRoomPrice(room, price);
    }

    public String getSortEmptyRoomsByCapacity() {
        Arrays.sort(roomStorage.getEmptyRoomInHotel(), new RoomComparator().getCapacityComparator());
        return roomStorage.getListOfEmptyRooms();

    }

    public String getSortRoomsByCapacity() {
        Arrays.sort(roomStorage.getArrayRoom(), new RoomComparator().getCapacityComparator());
        return roomStorage.getListOfRooms();
    }

    public void setDatesOfGuestStayAndBusy(Room room, Date arrivalDate, Date dateOfDeparture) {
        Boolean busy = Boolean.TRUE;
        if ((arrivalDate == null) && (dateOfDeparture == null)) {
            busy = Boolean.FALSE;
        }
        roomStorage.setDatesOfGuestStay(busy, room, arrivalDate, dateOfDeparture);
    }

    public String getSortEmptyRoomsByPrice() {
        Arrays.sort(roomStorage.getEmptyRoomInHotel(), new RoomComparator().getPriceComparator());
        return roomStorage.getListOfEmptyRooms();

    }

    public String getSortEmptyRoomsByNumberOfStars() {
        Arrays.sort(roomStorage.getEmptyRoomInHotel(), new RoomComparator().getNumberStarsComparator());
        return roomStorage.getListOfEmptyRooms();
    }

    public String getSortRoomsByPrice() {
        Arrays.sort(roomStorage.getArrayRoom(), new RoomComparator().getPriceComparator());
        return roomStorage.getListOfRooms();
    }

    public String getSortRoomsByNumberOfStars() {
        Arrays.sort(roomStorage.getArrayRoom(), new RoomComparator().getNumberStarsComparator());
        return roomStorage.getListOfRooms();
    }

}
