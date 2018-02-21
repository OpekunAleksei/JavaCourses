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
import com.senla.hotel.dbconnector.DbConnector;
import com.senla.hotel.utils.Converter;
import java.sql.SQLException;

public class RoomManager implements IRoomManager {

    private final DbConnector dbConnector = new DbConnector();
    private final IRoomDao roomDao;
    private final Converter converter;

    public RoomManager() {
        this.converter = new Converter();
        this.roomDao = new RoomDaoImpl();

    }

    @Override
    public void setImportRooms(List<Room> list) throws SQLException {

        roomDao.setImportRooms(dbConnector.getConnection(), list);

    }

    @Override
    public List<Room> getRooms() throws SQLException {
        roomDao.setEmpty(Boolean.TRUE);

        return roomDao.getAll(dbConnector.getConnection(), "zero");

    }

    @Override
    public Integer getIdByNumberOnList(Integer number) throws SQLException {

        return roomDao.getIdByNumberOnlist(dbConnector.getConnection(), number);

    }

    @Override
    public void createRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, RoomStatus status) throws SQLException {

        roomDao.create(dbConnector.getConnection(), roomDao.createMiracleRoom(number, price, capacity, numberOfStars, status));

    }

    @Override
    public void changeRoomPrice(Integer numberOfRoom, Integer price) throws SQLException {

        roomDao.changePartOfRoom(dbConnector.getConnection(), numberOfRoom, price, "price");

    }

    @Override
    public void changeRoomStatus(Integer numberOfRoom, RoomStatus status) throws SQLException {

        roomDao.changePartOfRoom(dbConnector.getConnection(), numberOfRoom, status, "status");

    }

    @Override
    public void changeNumberOfStars(Integer numberOfRoom, Integer numberOfStars) throws SQLException {

        roomDao.changePartOfRoom(dbConnector.getConnection(), numberOfRoom, numberOfStars, "numberOfStars");

    }

    @Override
    public void changeCapacity(Integer numberOfRoom, Integer capacity) throws SQLException {

        roomDao.changePartOfRoom(dbConnector.getConnection(), numberOfRoom, capacity, "capacity");

    }

    @Override
    public void changeRoomBusy(Integer numberOfRoom, Boolean busy) throws SQLException {

        roomDao.changePartOfRoom(dbConnector.getConnection(), numberOfRoom, busy, "busy");

    }

    @Override
    public void copyRoom(Integer numberOfRoom, Integer newNumber) throws SQLException, CloneNotSupportedException {

        roomDao.copyRoom(dbConnector.getConnection(), numberOfRoom, newNumber);

    }

    @Override
    public Integer getNumberEmptyRoomInHotel() throws SQLException {

        return roomDao.getNumberEmptyRoom(dbConnector.getConnection());

    }

    @Override
    public Room getRoom(Integer numberOfRoom) throws SQLException {

        return roomDao.getById(dbConnector.getConnection(), numberOfRoom);

    }

    @Override
    public List<Room> getDetailsOfRoom(Integer id) throws SQLException {

        return roomDao.getMiracleRoomList(dbConnector.getConnection(), id);

    }

    @Override
    public List<Room> getListRooms(String name, String busy) throws SQLException {
        roomDao.setEmpty(converter.booleanConverter(busy));

        return roomDao.getAll(dbConnector.getConnection(), name);

    }
}
