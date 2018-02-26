/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.managers;

import com.senla.hotel.api.dao.IRoomDao;
import com.senla.hotel.entity.Room;
import java.util.List;
import com.senla.hotel.api.managers.IRoomManager;
import com.senla.hotel.daoimpl.RoomDaoImpl;
import com.senla.hotel.dbconnector.DbConnector;
import com.senla.hotel.hibernateutil.HibernateUtil;
import com.senla.hotel.utils.Converter;
import java.sql.SQLException;
import org.hibernate.Session;

public class RoomManager implements IRoomManager {

    private final IRoomDao roomDao;
    private final Converter converter;

    public RoomManager() {
        this.converter = new Converter();
        this.roomDao = new RoomDaoImpl();

    }

    @Override
    public void setImportRooms(List<Room> list) throws SQLException {
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            roomDao.setImportRooms(session, list);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Room> getRooms() throws SQLException {

        List<Room> list;
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            roomDao.setEmpty(Boolean.TRUE);
            list = roomDao.getAll(session, "zero");
            session.getTransaction().commit();
            roomDao.setEmpty(Boolean.FALSE);
            return list;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Integer getIdByNumberOnList(Integer number) throws SQLException {
        Session session = HibernateUtil.getIstance().getSession();
        Integer result;
        try {
            session.beginTransaction();
            roomDao.setEmpty(Boolean.TRUE);
            result = roomDao.getIdByNumberOnlist(session, number);
            session.getTransaction().commit();
            return result;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void createRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, String status) throws SQLException {
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            roomDao.create(session, roomDao.createMiracleRoom(number, price, capacity, numberOfStars, status));
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public void changeRoomPrice(Integer numberOfRoom, Integer price) throws SQLException {

        roomDao.changePartOfRoom(DbConnector.getIstance().getConnection(), numberOfRoom, price, "price");

    }

    @Override
    public void changeRoomStatus(Integer numberOfRoom, String status) throws SQLException {

        roomDao.changePartOfRoom(DbConnector.getIstance().getConnection(), numberOfRoom, status, "status");

    }

    @Override
    public void changeNumberOfStars(Integer numberOfRoom, Integer numberOfStars) throws SQLException {
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            roomDao.changePartOfRoom(DbConnector.getIstance().getConnection(), numberOfRoom, numberOfStars, "numberOfStars");
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public void changeCapacity(Integer numberOfRoom, Integer capacity) throws SQLException {
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            roomDao.changePartOfRoom(DbConnector.getIstance().getConnection(), numberOfRoom, capacity, "capacity");
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void changeRoomBusy(Integer numberOfRoom, Boolean busy) throws SQLException {
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            roomDao.changePartOfRoom(DbConnector.getIstance().getConnection(), numberOfRoom, busy, "busy");
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public void copyRoom(Integer numberOfRoom, Integer newNumber) throws SQLException, CloneNotSupportedException {
        Session session = HibernateUtil.getIstance().getSession();
        Room room;
        try {
            session.beginTransaction();
            room = roomDao.copyRoom(session, numberOfRoom, newNumber);

            roomDao.create(session, room);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public Integer getNumberEmptyRoomInHotel() throws SQLException {
        Integer result;
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            result = roomDao.getNumberEmptyRoom(DbConnector.getIstance().getConnection());
            session.getTransaction().commit();
            return result;
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public Room getRoom(Integer numberOfRoom) throws SQLException {
        Room room;
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            room = roomDao.getById(session, numberOfRoom);
            session.getTransaction().commit();
            return room;
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public List<Room> getDetailsOfRoom(Integer id) throws SQLException {
        List<Room> list;
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            list = roomDao.getMiracleRoomList(session, id);
            session.getTransaction().commit();
            return list;
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public List<Room> getListRooms(String name, String busy) throws SQLException {
        Session session = HibernateUtil.getIstance().getSession();
        List<Room> list;
        try {

            session.beginTransaction();
            roomDao.setEmpty(converter.booleanConverter(busy));
            list = roomDao.getAll(session, name);
            session.getTransaction().commit();
            return list;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
