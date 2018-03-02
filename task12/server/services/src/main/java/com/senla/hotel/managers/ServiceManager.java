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

public class ServiceManager implements IServiceManager {

    private static Logger logger = Logger.getLogger(ServiceManager.class);
    private final IServiceDao serviceDao;

    public ServiceManager() {
        this.serviceDao = new ServiceDaoImpl();

    }

    @Override
    public Integer getIdByNumberOnList(Integer number) throws Exception {
        Integer result;
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            result = serviceDao.getIdByNumberOnlist(session, number);
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
    public void setImportServices(List<Service> list) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            serviceDao.setImportServices(session, list);
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
    public List<Service> getServices() throws Exception {
        List<Service> list;
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            list = serviceDao.getAll(session, "zero");
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
    public void createService(Integer price, String category) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            serviceDao.create(session, serviceDao.getMiracleService(price, category));
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
    public Service getService(Integer serviceId) throws Exception {
        Service service;
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            service = serviceDao.getById(session, serviceId);
            session.getTransaction().commit();
            return service;
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
    public void changeServicePrice(Integer id, Integer price) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        try {
            session.beginTransaction();
            serviceDao.changePrice(session, id, price);
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
}
