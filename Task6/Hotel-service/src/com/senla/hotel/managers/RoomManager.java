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

    public RoomManager(String path) {
        RoomStorage.getInstance().setPath(path);
    }

    public void importRooms(String path) throws IOException {
        RoomStorage.getInstance().importRooms(path);
    }

    public void exportRooms(String path) throws IOException {
        RoomStorage.getInstance().exportRooms(path);
    }

    public List<Room> getRooms() {
        return RoomStorage.getInstance().getRooms();
    }

    public Integer getIdByNumberOnList(Integer number) {
        return RoomStorage.getInstance().getIdByNumberOnList(number);
    }

    public void deserializeData() {
        RoomStorage.getInstance().deserializeData();
    }

    public void serializeData() {
        RoomStorage.getInstance().serializeData();
    }

    public void createRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, Integer id, RoomStatus status) {
        RoomStorage.getInstance().createRoom(number, price, capacity, numberOfStars, id, status);
    }

    public void changeRoomPrice(Integer numberOfRoom, Integer price) {
        RoomStorage.getInstance().changeRoomPrice(numberOfRoom, price);
    }

    public void changeRoomStatus(Integer numberOfRoom, RoomStatus status) {
        RoomStorage.getInstance().changeRoomStatus(numberOfRoom, status);
    }

    public void changeNumberOfStars(Integer numberOfRoom, Integer numberOfStars) {
        RoomStorage.getInstance().changeNumberOfStars(numberOfRoom, numberOfStars);
    }

    public void changeCapacity(Integer numberOfRoom, Integer capacity) {
        RoomStorage.getInstance().changeNumberOfStars(numberOfRoom, capacity);
    }

    public void changeRoomBusy(Integer numberOfRoom, Boolean busy) {

        RoomStorage.getInstance().changeRoomBusy(numberOfRoom, busy);
    }

    public void copyRoom(Integer numberOfRoom, Integer newId, Integer newNumber) throws CloneNotSupportedException {
        RoomStorage.getInstance().copyRoom(numberOfRoom, newId, newNumber);
    }

    public Integer getNumberEmptyRoomInHotel() {
        return RoomStorage.getInstance().getNumberEmptyRoom();
    }

    public Room getRoom(Integer numberOfRoom) {

        return RoomStorage.getInstance().getRoom(numberOfRoom);
    }

    public List<Room> getDetailsOfRoom(Integer numberOfRoom) {
        return RoomStorage.getInstance().getDetailsOfRoom(numberOfRoom);
    }

    public void sorting(Comparator comparator1, Comparator comparator2) {
        List aList = RoomStorage.getInstance().getRooms();
        Collections.sort(aList, comparator1.thenComparing(comparator2));
    }

    public void sorting(Comparator comparator) {
        List aList = RoomStorage.getInstance().getRooms();
        Collections.sort(aList, comparator);
    }

}
