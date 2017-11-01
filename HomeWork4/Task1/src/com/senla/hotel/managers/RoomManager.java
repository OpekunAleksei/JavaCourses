/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.managers;

import com.senla.hotel.entity.Room;
import com.senla.hotel.comparators.RoomComparator;
import com.senla.hotel.enums.RoomStatus;
import com.senla.hotel.storages.RoomStorage;
import java.util.Arrays;


public class RoomManager {

    private RoomStorage roomStorage;

    public RoomManager(String path) {
        roomStorage = new RoomStorage(path);
    }

    public void a() {
        roomStorage.a();
    }

    public void createRoom() {
        roomStorage.createRoom();
    }

    public void changeRoomPrice(Integer numberOfRoom, Integer price) {
        roomStorage.changeRoomPrice(numberOfRoom, price);
    }

    public void changeRoomStatus(Integer numberOfRoom, RoomStatus status) {
        roomStorage.changeRoomStatus(numberOfRoom, status);
    }

    public void changeRoomBusy(Integer numberOfRoom, Boolean busy) {

        roomStorage.changeRoomBusy(numberOfRoom, busy);
    }

    public Integer getNumberEmptyRoomInHotel() {
        return roomStorage.getNumberEmptyRoomInHotel();
    }

    public Room getRoom(Integer numberOfRoom) {

        return roomStorage.getRoom(numberOfRoom);
    }

    public String getDetailsOfRoom(Integer numberOfRoom) {
        return roomStorage.getDetailsOfRoom(numberOfRoom);
    }

    public Room entryToTable() {

        return roomStorage.getRoom();
    }

    public String getSortEmptyRoomsByCapacity() {
        Arrays.sort(roomStorage.getArrayRoom(), new RoomComparator().getBusyComparator().thenComparing(new RoomComparator().getCapacityComparator()));
        return roomStorage.getLisOfEmptyRooms();

    }

    public String getSortRoomsByCapacity() {
        Arrays.sort(roomStorage.getArrayRoom(), new RoomComparator().getCapacityComparator());
        return roomStorage.getLisOfRooms();
    }

    public String getSortEmptyRoomsByPrice() {
        Arrays.sort(roomStorage.getArrayRoom(), new RoomComparator().getBusyComparator().thenComparing(new RoomComparator().getPriceComparator()));
        return roomStorage.getLisOfEmptyRooms();

    }

    public String getSortEmptyRoomsByNumberOfStars() {
        Arrays.sort(roomStorage.getArrayRoom(), new RoomComparator().getBusyComparator().thenComparing(new RoomComparator().getNumberStarsComparator()));
        return roomStorage.getLisOfEmptyRooms();
    }

    public String getSortRoomsByPrice() {
        Arrays.sort(roomStorage.getArrayRoom(), new RoomComparator().getPriceComparator());
        return roomStorage.getLisOfRooms();
    }

    public String getSortRoomsByNumberOfStars() {
        Arrays.sort(roomStorage.getArrayRoom(), new RoomComparator().getNumberStarsComparator());
        return roomStorage.getLisOfRooms();
    }

}
