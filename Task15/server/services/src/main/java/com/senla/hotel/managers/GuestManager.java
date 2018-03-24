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
import org.hibernate.Transaction;

public class GuestManager implements IGuestManager {

    private final IGuestDao guestDao;
    private static Logger logger = Logger.getLogger(GuestManager.class);

    public GuestManager() {
        this.guestDao = new GuestDaoImpl();

    }

    @Override
    public void setImpotrGuests(List<Guest> list) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            guestDao.setImportGuests(session, list);
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
    public Integer getIdByNumberOnList(Integer number) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Integer result = guestDao.getIdByNumberOnlist(session, number);
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
    public void createGuest(Guest guest) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            guestDao.create(session, guest);
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
    public Guest getGuestByID(Integer id) throws Exception {

        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Guest guest = guestDao.getById(session, id);
            transaction.commit();
            return guest;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception();
        }
    }

    @Override
    public List<Guest> getListOfGuest(String name) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            List<Guest> list = guestDao.getAll(session, name);
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
