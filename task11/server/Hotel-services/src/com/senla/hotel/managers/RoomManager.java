/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.managers;

import com.senla.hotel.api.dao.IRoomDao;
import com.senla.hotel.entity.Room;
import com.senla.hotel.enums.RoomStatus;
import java.util.List;
import com.senla.hotel.api.managers.IRoomManager;
import com.senla.hotel.daoimpl.RoomDaoImpl;
import java.util.ArrayList;

public class RoomManager implements IRoomManager {

    public IRoomDao roomDao = new RoomDaoImpl();

    public RoomManager() {

    }

    @Override
    public void setImportRooms(List<Room> list) {
        roomDao.setImportRooms(list);

    }

    @Override
    public List<Room> getRooms() {
        return roomDao.getAll();

    }

    @Override
    public Integer getIdByNumberOnList(Integer number) {

        return roomDao.getIdByNumberOnlist(number);

    }

    @Override
    public void createRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, RoomStatus status) {
        Room room = new Room(number, price, capacity, numberOfStars, null, status, false);
        roomDao.create(room);
    }

    @Override
    public void changeRoomPrice(Integer numberOfRoom, Integer price) {
        roomDao.changePartOfRoom(numberOfRoom, price, "price");

    }

    @Override
    public void changeRoomStatus(Integer numberOfRoom, RoomStatus status) {
        roomDao.changePartOfRoom(numberOfRoom, status, "status");

    }

    @Override
    public void changeNumberOfStars(Integer numberOfRoom, Integer numberOfStars) {
        roomDao.changePartOfRoom(numberOfRoom, numberOfStars, "numberOfStars");

    }

    @Override
    public void changeCapacity(Integer numberOfRoom, Integer capacity) {

        roomDao.changePartOfRoom(numberOfRoom, capacity, "capacity");

    }

    @Override
    public void changeRoomBusy(Integer numberOfRoom, Boolean busy) {
        roomDao.changePartOfRoom(numberOfRoom, busy, "busy");

    }

    @Override
    public void copyRoom(Integer numberOfRoom,  Integer newNumber) {
        roomDao.copyRoom(numberOfRoom, newNumber);

    }

    @Override
    public Integer getNumberEmptyRoomInHotel() {
        return roomDao.getNumberEmptyRoom();

    }

    @Override
    public Room getRoom(Integer numberOfRoom) {
        return roomDao.getByID(numberOfRoom);

    }

    @Override
    public List<Room> getDetailsOfRoom(Integer id) {
        List<Room> room = new ArrayList();
        room.add(roomDao.getByID(id));
        return room;

    }

    @Override
    public List<Room> sorting(String name, Boolean busy) {

        return roomDao.getSortingListOfRooms(name, busy);
    }

}
