/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.managers;

import com.senla.hotel.api.dao.IServiceDao;
import com.senla.hotel.entity.Service;
import java.util.List;
import com.senla.hotel.api.managers.IServiceManager;
import com.senla.hotel.daoimpl.ServiceDaoImpl;
import com.senla.hotel.dbconnector.DbConnector;
import com.senla.hotel.hibernateutil.HibernateUtil;
import java.sql.SQLException;
import org.hibernate.Session;

public class ServiceManager implements IServiceManager {

    private final IServiceDao serviceDao;

    public ServiceManager() {
        this.serviceDao = new ServiceDaoImpl();

    }

    @Override
    public Integer getIdByNumberOnList(Integer number) throws SQLException {
        Integer result;
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            result = serviceDao.getIdByNumberOnlist(session, number);
            session.getTransaction().commit();
            return result;
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public void setImportServices(List<Service> list) throws SQLException {
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            serviceDao.setImportServices(session, list);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Service> getServices() throws SQLException {
        List<Service> list;
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            list = serviceDao.getAll(session, "zero");
            session.getTransaction().commit();
            return list;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void createService(Integer price, String category) throws SQLException {
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            serviceDao.create(session, serviceDao.getMiracleService(price, category));
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public Service getService(Integer serviceId) throws SQLException {
        Service service;
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            service = serviceDao.getById(session, serviceId);
            session.getTransaction().commit();
            return service;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void changeServicePrice(Integer id, Integer price) throws SQLException {
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            serviceDao.changePrice(DbConnector.getIstance().getConnection(), id, price);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
