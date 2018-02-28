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

<<<<<<< HEAD
   
=======
    private final DbConnector dbConnector = new DbConnector();
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a
    private final IRoomDao roomDao;
    private final Converter converter;

    public RoomManager() {
        this.converter = new Converter();
        this.roomDao = new RoomDaoImpl();

    }

    @Override
    public void setImportRooms(List<Room> list) throws SQLException {

<<<<<<< HEAD
        roomDao.setImportRooms(DbConnector.getIstance().getConnection(), list);
=======
        roomDao.setImportRooms(dbConnector.getConnection(), list);
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

    @Override
    public List<Room> getRooms() throws SQLException {
        roomDao.setEmpty(Boolean.TRUE);

<<<<<<< HEAD
        return roomDao.getAll(DbConnector.getIstance().getConnection(), "zero");
=======
        return roomDao.getAll(dbConnector.getConnection(), "zero");
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

    @Override
    public Integer getIdByNumberOnList(Integer number) throws SQLException {

<<<<<<< HEAD
        return roomDao.getIdByNumberOnlist(DbConnector.getIstance().getConnection(), number);
=======
        return roomDao.getIdByNumberOnlist(dbConnector.getConnection(), number);
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

    @Override
    public void createRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, RoomStatus status) throws SQLException {

<<<<<<< HEAD
        roomDao.create(DbConnector.getIstance().getConnection(), roomDao.createMiracleRoom(number, price, capacity, numberOfStars, status));
=======
        roomDao.create(dbConnector.getConnection(), roomDao.createMiracleRoom(number, price, capacity, numberOfStars, status));
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

    @Override
    public void changeRoomPrice(Integer numberOfRoom, Integer price) throws SQLException {

<<<<<<< HEAD
        roomDao.changePartOfRoom(DbConnector.getIstance().getConnection(), numberOfRoom, price, "price");
=======
        roomDao.changePartOfRoom(dbConnector.getConnection(), numberOfRoom, price, "price");
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

    @Override
    public void changeRoomStatus(Integer numberOfRoom, RoomStatus status) throws SQLException {

<<<<<<< HEAD
        roomDao.changePartOfRoom(DbConnector.getIstance().getConnection(), numberOfRoom, status, "status");
=======
        roomDao.changePartOfRoom(dbConnector.getConnection(), numberOfRoom, status, "status");
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

    @Override
    public void changeNumberOfStars(Integer numberOfRoom, Integer numberOfStars) throws SQLException {

<<<<<<< HEAD
        roomDao.changePartOfRoom(DbConnector.getIstance().getConnection(), numberOfRoom, numberOfStars, "numberOfStars");
=======
        roomDao.changePartOfRoom(dbConnector.getConnection(), numberOfRoom, numberOfStars, "numberOfStars");
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

    @Override
    public void changeCapacity(Integer numberOfRoom, Integer capacity) throws SQLException {

<<<<<<< HEAD
        roomDao.changePartOfRoom(DbConnector.getIstance().getConnection(), numberOfRoom, capacity, "capacity");
=======
        roomDao.changePartOfRoom(dbConnector.getConnection(), numberOfRoom, capacity, "capacity");
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

    @Override
    public void changeRoomBusy(Integer numberOfRoom, Boolean busy) throws SQLException {

<<<<<<< HEAD
        roomDao.changePartOfRoom(DbConnector.getIstance().getConnection(), numberOfRoom, busy, "busy");
=======
        roomDao.changePartOfRoom(dbConnector.getConnection(), numberOfRoom, busy, "busy");
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

    @Override
    public void copyRoom(Integer numberOfRoom, Integer newNumber) throws SQLException, CloneNotSupportedException {

<<<<<<< HEAD
        roomDao.copyRoom(DbConnector.getIstance().getConnection(), numberOfRoom, newNumber);
=======
        roomDao.copyRoom(dbConnector.getConnection(), numberOfRoom, newNumber);
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

    @Override
    public Integer getNumberEmptyRoomInHotel() throws SQLException {

<<<<<<< HEAD
        return roomDao.getNumberEmptyRoom(DbConnector.getIstance().getConnection());
=======
        return roomDao.getNumberEmptyRoom(dbConnector.getConnection());
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

    @Override
    public Room getRoom(Integer numberOfRoom) throws SQLException {

<<<<<<< HEAD
        return roomDao.getById(DbConnector.getIstance().getConnection(), numberOfRoom);
=======
        return roomDao.getById(dbConnector.getConnection(), numberOfRoom);
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

    @Override
    public List<Room> getDetailsOfRoom(Integer id) throws SQLException {

<<<<<<< HEAD
        return roomDao.getMiracleRoomList(DbConnector.getIstance().getConnection(), id);
=======
        return roomDao.getMiracleRoomList(dbConnector.getConnection(), id);
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

    @Override
    public List<Room> getListRooms(String name, String busy) throws SQLException {
        roomDao.setEmpty(converter.booleanConverter(busy));

<<<<<<< HEAD
        return roomDao.getAll(DbConnector.getIstance().getConnection(), name);
=======
        return roomDao.getAll(dbConnector.getConnection(), name);
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }
}
