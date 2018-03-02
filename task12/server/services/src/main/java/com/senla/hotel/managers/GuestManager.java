/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.managers;

import com.senla.hotel.api.dao.IGuestDao;
import com.senla.hotel.entity.Guest;
import java.util.Date;
import java.util.List;
import com.senla.hotel.api.managers.IGuestManager;
import com.senla.hotel.daoimpl.GuestDaoImpl;
import com.senla.hotel.hibernateutil.HibernateUtil;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.hibernate.Session;

public class GuestManager implements IGuestManager {

    private final IGuestDao guestDao;
    private static Logger logger = Logger.getLogger(GuestManager.class);

    public GuestManager() {
        this.guestDao = new GuestDaoImpl();

    }

    @Override
    public void setImpotrGuests(List<Guest> list) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            guestDao.setImportGuests(session, list);
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
    public Integer getIdByNumberOnList(Integer number) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Integer result = null;
        try {
            session.beginTransaction();
            result = guestDao.getIdByNumberOnlist(session, number);
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
    public void createGuest(String name, Date arrivalDate, Date dateOfDeparture) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            guestDao.create(session, guestDao.createMiracleGuest(name, arrivalDate, dateOfDeparture));
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
    public Guest getGuestByID(Integer id) throws Exception {
        Guest guest;
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            guest = guestDao.getById(session, id);
            session.getTransaction().commit();
            return guest;
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
    public List<Guest> getListOfGuest(String name) throws Exception {
        List<Guest> list;

        Session session = HibernateUtil.getIstance().getSession();
        try {

            session.beginTransaction();
            list = guestDao.getAll(session, name);

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

}
