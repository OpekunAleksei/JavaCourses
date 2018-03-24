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
import com.senla.hotel.hibernateutil.HibernateUtil;
import java.sql.SQLException;
import java.util.Date;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ServiceManager implements IServiceManager {

    private static Logger logger = Logger.getLogger(ServiceManager.class);
    private final IServiceDao serviceDao;

    public ServiceManager() {
        this.serviceDao = new ServiceDaoImpl();
    }

    @Override
    public Integer getIdByNumberOnList(Integer number) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Integer result = serviceDao.getIdByNumberOnlist(session, number);
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
    public void setImportServices(List<Service> list) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            serviceDao.setImportServices(session, list);
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
    public List<Service> getServices() throws Exception {

        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            List<Service> list = serviceDao.getAll(session, "zero");
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
    public void createService(Service service) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            serviceDao.create(session, service);
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
    public Service getService(Integer serviceId) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Service service = serviceDao.getById(session, serviceId);
            transaction.commit();
            return service;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception();
        }
    }

    @Override
    public void changeServicePrice(Integer id, Integer price) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            serviceDao.changePrice(session, id, price);
            transaction.commit();
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception();
        }

    }
}
