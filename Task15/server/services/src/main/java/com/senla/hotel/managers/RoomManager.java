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
import com.senla.hotel.hibernateutil.HibernateUtil;
import java.sql.SQLException;
import java.util.Date;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RoomManager implements IRoomManager {

    private static Logger logger = Logger.getLogger(RoomManager.class);
    private final IRoomDao roomDao;

    public RoomManager() {
        this.roomDao = new RoomDaoImpl();

    }

    @Override
    public void setImportRooms(List<Room> list) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            roomDao.setImportRooms(session, list);
            transaction.commit();
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception();
        }
    }

    @Override
    public List<Room> getRooms() throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            roomDao.setEmpty(Boolean.TRUE);
            List<Room> list = roomDao.getAll(session, "zero");
            roomDao.setEmpty(Boolean.FALSE);
            transaction.commit();
            return list;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception();
        }
    }

    @Override
    public Integer getIdByNumberOnList(Integer number) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            roomDao.setEmpty(Boolean.TRUE);
            Integer result = roomDao.getIdByNumberOnlist(session, number);
            transaction.commit();
            return result;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception();
        }
    }

    @Override
    public void createRoom(Room room) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            roomDao.create(session, room);
            transaction.commit();
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception();
        }

    }

    @Override
    public void changeRoomPrice(Integer numberOfRoom, Integer price) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            roomDao.changePartOfRoom(session, numberOfRoom, price, "price");
            transaction.commit();
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception();
        }
    }

    @Override
    public void changeRoomStatus(Integer numberOfRoom, String status) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            roomDao.changePartOfRoom(session, numberOfRoom, status, "status");
            transaction.commit();
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception();
        }

    }

    @Override
    public void changeNumberOfStars(Integer numberOfRoom, Integer numberOfStars) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            roomDao.changePartOfRoom(session, numberOfRoom, numberOfStars, "numberOfStars");
            transaction.commit();
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception();
        }

    }

    @Override
    public void changeCapacity(Integer numberOfRoom, Integer capacity) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            roomDao.changePartOfRoom(session, numberOfRoom, capacity, "capacity");
            transaction.commit();
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception();
        }
    }

    @Override
    public void changeRoomBusy(Integer numberOfRoom, Boolean busy) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            roomDao.changePartOfRoom(session, numberOfRoom, busy, "busy");
            transaction.commit();
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception();
        }

    }

    @Override
    public void copyRoom(Integer numberOfRoom, Integer newNumber) throws Exception, CloneNotSupportedException {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Room room = roomDao.copyRoom(session, numberOfRoom, newNumber);
            roomDao.create(session, room);
            transaction.commit();
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception();
        }

    }

    @Override
    public Integer getNumberEmptyRoomInHotel() throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Integer result = roomDao.getNumberEmptyRoom(session);
            transaction.commit();
            return result;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception();
        }

    }

    @Override
    public Room getRoom(Integer numberOfRoom) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Room room = roomDao.getById(session, numberOfRoom);
            transaction.commit();
            return room;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception();
        }

    }

    @Override
    public List<Room> getDetailsOfRoom(Integer id) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            List<Room> list = roomDao.getMiracleRoomList(session, id);
            transaction.commit();
            return list;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception();
        }

    }

    @Override
    public List<Room> getListRooms(String name, Boolean busy) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            roomDao.setEmpty(busy);
            List<Room> list = roomDao.getAll(session, name);
            transaction.commit();
            return list;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception();
        }
    }
}
