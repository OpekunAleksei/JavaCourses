/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.managers;

import com.senla.hotel.entity.Room;
import com.senla.hotel.enums.RoomStatus;
import com.senla.hotel.storages.RoomStorage;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RoomManager {

    private final RoomStorage roomStorage;

    public RoomManager(String path) {
        roomStorage = new RoomStorage(path);
    }

    public void importRooms(String path) throws IOException {
        roomStorage.importRooms(path);
    }

    public void exportRooms(String path) throws IOException {
        roomStorage.exportRooms(path);
    }

    public List<Room> getRooms() {
        return roomStorage.getRooms();
    }

    public Integer getIdByNumberOnList(Integer number) {
        return roomStorage.getIdByNumberOnList(number);
    }

    public void deserializeData() {
        roomStorage.deserializeData();
    }

    public void serializeData() {
        roomStorage.serializeData();
    }

    public void createRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, Integer id, RoomStatus status) {
        roomStorage.createRoom(number, price, capacity, numberOfStars, id, status);
    }

    public void changeRoomPrice(Integer numberOfRoom, Integer price) {
        roomStorage.changeRoomPrice(numberOfRoom, price);
    }

    public void changeRoomStatus(Integer numberOfRoom, RoomStatus status) {
        roomStorage.changeRoomStatus(numberOfRoom, status);
    }

    public void changeNumberOfStars(Integer numberOfRoom, Integer numberOfStars) {
        roomStorage.changeNumberOfStars(numberOfRoom, numberOfStars);
    }

    public void changeCapacity(Integer numberOfRoom, Integer capacity) {
        roomStorage.changeNumberOfStars(numberOfRoom, capacity);
    }

    public void changeRoomBusy(Integer numberOfRoom, Boolean busy) {

        roomStorage.changeRoomBusy(numberOfRoom, busy);
    }

    public void copyRoom(Integer numberOfRoom, Integer newId, Integer newNumber) throws CloneNotSupportedException {
        roomStorage.copyRoom(numberOfRoom, newId, newNumber);
    }

    public Integer getNumberEmptyRoomInHotel() {
        return roomStorage.getNumberEmptyRoom();
    }

    public Room getRoom(Integer numberOfRoom) {

        return roomStorage.getRoom(numberOfRoom);
    }

    public String getDetailsOfRoom(Integer numberOfRoom) {
        return roomStorage.getDetailsOfRoom(numberOfRoom);
    }

    public String sorting(Comparator comparator1, Comparator comparator2) {
        List aList = roomStorage.getRooms();
        Collections.sort(aList, comparator1.thenComparing(comparator2));
        return roomStorage.getLisOfEmptyRooms();
    }

    public String sorting(Comparator comparator) {
        List aList = roomStorage.getRooms();
        Collections.sort(aList, comparator);
        return roomStorage.getLisOfRooms();
    }

}
