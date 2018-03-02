/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.managers;

import com.senla.hotel.api.dao.IHistoryDao;
import com.senla.hotel.api.dao.IRoomDao;
import com.senla.hotel.entity.Service;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Guest;
import java.util.Date;
import java.util.List;
import com.senla.hotel.api.managers.IHistoryManager;
import com.senla.hotel.daoimpl.HistoryDaoImpl;
import com.senla.hotel.daoimpl.RoomDaoImpl;

import com.senla.hotel.hibernateutil.HibernateUtil;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.hibernate.Session;

public class HistoryManager implements IHistoryManager {

    private static Logger logger = Logger.getLogger(HistoryManager.class);
    private final IRoomDao roomDao;
    private final IHistoryDao historyDao;

    public HistoryManager() {
        this.roomDao = new RoomDaoImpl();

        this.historyDao = new HistoryDaoImpl();

    }

    @Override
    public void settleInRoom(Guest guest, Room room) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            roomDao.changePartOfRoom(session, room.getId(), Boolean.FALSE, "busy");
            historyDao.create(session, historyDao.getMiracleHistory(guest, room, Boolean.FALSE));
            session.getTransaction().commit();

        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            session.getTransaction().rollback();
            throw new Exception();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void evictedFromRoom(Guest guest, Room room) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            if (historyDao.checForPresense(session, room) == false) {
                roomDao.changePartOfRoom(session, room.getId(), Boolean.TRUE, "busy");
            }
            historyDao.update(session, historyDao.getMiracleHistory(session, guest, room, Boolean.TRUE));
            session.getTransaction().commit();

        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            session.getTransaction().rollback();
            throw new Exception();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void addServiceToGuest(Service service, Guest guest, Room room) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            historyDao.setService(session, guest, room, service);
            session.getTransaction().commit();
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            session.getTransaction().rollback();
            throw new Exception();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public Long getGuestPriceForAccommodation(Guest guest, Room room) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Long result;
        try {
            session.beginTransaction();
            result = historyDao.getPriceForAccommodation(session, guest, room);
            session.getTransaction().commit();
            return result;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            session.getTransaction().rollback();
            throw new Exception();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Integer getNumberGuestInHotel() throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Integer result;
        try {
            session.beginTransaction();
            result = historyDao.getNumberOfGuestInHotel(session);
            session.getTransaction().commit();
            return result;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            session.getTransaction().rollback();
            throw new Exception();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public List<Guest> getListLeftGuestThisRoom(Room room, Integer count) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        List<Guest> list;
        try {
            session.beginTransaction();
            list = historyDao.getListLeftGuest(session, room, count);
            session.getTransaction().commit();
            return list;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            session.getTransaction().rollback();
            throw new Exception();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Room> getListOfRoomsAvailableByDate(Date date) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        List<Room> list;
        try {
            session.beginTransaction();
            list = historyDao.getIdRoomsAvalableByDate(session, date);
            session.getTransaction().commit();
            return list;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            session.getTransaction().rollback();
            throw new Exception();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Service> getGuestServices(Guest guest, Room room, String sort) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        List<Service> list;
        try {
            session.beginTransaction();
            list = historyDao.getGuestService(session, guest, room, sort);
            session.getTransaction().commit();
            return list;
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
            session.getTransaction().rollback();
            throw new Exception();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
