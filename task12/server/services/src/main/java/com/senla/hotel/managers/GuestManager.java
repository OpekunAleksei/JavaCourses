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
import org.hibernate.Session;

public class GuestManager implements IGuestManager {

    private final IGuestDao guestDao;

    public GuestManager() {
        this.guestDao = new GuestDaoImpl();

    }

    @Override
    public void setImpotrGuests(List<Guest> list) throws SQLException {
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            guestDao.setImportGuests(session, list);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public Integer getIdByNumberOnList(Integer number) throws SQLException {
        Session session = HibernateUtil.getIstance().getSession();
        Integer result = null;
        try {
            session.beginTransaction();
            result = guestDao.getIdByNumberOnlist(session, number);
            session.getTransaction().commit();
            return result;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void createGuest(String name, Date arrivalDate, Date dateOfDeparture) throws SQLException {
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            guestDao.create(session, guestDao.createMiracleGuest(name, arrivalDate, dateOfDeparture));
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Guest getGuestByID(Integer id) throws SQLException {
        Guest guest;
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            guest = guestDao.getById(session, id);
            session.getTransaction().commit();
            return guest;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Guest> getListOfGuest(String name) throws SQLException {
        List<Guest> list;
       
        Session session = HibernateUtil.getIstance().getSession();
        try {
            System.err.println(name);
            session.beginTransaction();
            list = guestDao.getAll(session, name);

            session.getTransaction().commit();
            return list;
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

}
