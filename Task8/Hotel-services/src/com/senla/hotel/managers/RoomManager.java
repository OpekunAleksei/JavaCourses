/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.managers;

import com.senla.hotel.entity.Room;
import com.senla.hotel.enums.RoomStatus;
import com.senla.hotel.storages.RoomStorage;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.senla.hotel.api.managers.IRoomManager;

public class RoomManager implements IRoomManager {

    public RoomManager(String path) {
        RoomStorage.getInstance().setPath(path);
    }

    @Override
    public void setImportRooms(List<Room> list) {
        RoomStorage.getInstance().setImportRooms(list);
    }

    @Override
    public List<Room> getRooms() {
        return RoomStorage.getInstance().getRooms();
    }

    @Override
    public Integer getIdByNumberOnList(Integer number) {
        return RoomStorage.getInstance().getIdByNumberOnList(number);
    }

    @Override
    public void deserializeData() {
        RoomStorage.getInstance().deserializeData();
    }

    @Override
    public void serializeData() {
        RoomStorage.getInstance().serializeData();
    }

    @Override
    public void createRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, Integer id, RoomStatus status) {
        RoomStorage.getInstance().createRoom(number, price, capacity, numberOfStars, id, status);
    }

    @Override
    public void changeRoomPrice(Integer numberOfRoom, Integer price) {
        RoomStorage.getInstance().changeRoomPrice(numberOfRoom, price);
    }

    @Override
    public void changeRoomStatus(Integer numberOfRoom, RoomStatus status) {
        RoomStorage.getInstance().changeRoomStatus(numberOfRoom, status);
    }

    @Override
    public void changeNumberOfStars(Integer numberOfRoom, Integer numberOfStars) {
        RoomStorage.getInstance().changeNumberOfStars(numberOfRoom, numberOfStars);
    }

    @Override
    public void changeCapacity(Integer numberOfRoom, Integer capacity) {
        RoomStorage.getInstance().changeNumberOfStars(numberOfRoom, capacity);
    }

    @Override
    public void changeRoomBusy(Integer numberOfRoom, Boolean busy) {

        RoomStorage.getInstance().changeRoomBusy(numberOfRoom, busy);
    }

    @Override
    public void copyRoom(Integer numberOfRoom, Integer newId, Integer newNumber) {
        RoomStorage.getInstance().copyRoom(numberOfRoom, newId, newNumber);
    }

    @Override
    public Integer getNumberEmptyRoomInHotel() {
        return RoomStorage.getInstance().getNumberEmptyRoom();
    }

    @Override
    public Room getRoom(Integer numberOfRoom) {

        return RoomStorage.getInstance().getRoom(numberOfRoom);
    }

    @Override
    public List<Room> getDetailsOfRoom(Integer numberOfRoom) {
        return RoomStorage.getInstance().getDetailsOfRoom(numberOfRoom);
    }

    @Override
    public void sorting(Comparator comparator1, Comparator comparator2) {
        List aList = RoomStorage.getInstance().getRooms();
        Collections.sort(aList, comparator1.thenComparing(comparator2));
    }

    @Override
    public void sorting(Comparator comparator) {
        List aList = RoomStorage.getInstance().getRooms();
        Collections.sort(aList, comparator);
    }

}
