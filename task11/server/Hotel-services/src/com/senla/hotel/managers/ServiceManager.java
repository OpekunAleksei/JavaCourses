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
import java.sql.SQLException;

public class ServiceManager implements IServiceManager {

    private final IServiceDao serviceDao;
<<<<<<< HEAD

=======
    private final DbConnector dbConnector = new DbConnector();
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    public ServiceManager() {
        this.serviceDao = new ServiceDaoImpl();

    }

    @Override
    public Integer getIdByNumberOnList(Integer number) throws SQLException {

<<<<<<< HEAD
        return serviceDao.getIdByNumberOnlist(DbConnector.getIstance().getConnection(), number);
=======
        return serviceDao.getIdByNumberOnlist(dbConnector.getConnection(), number);
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

    @Override
    public void setImportServices(List<Service> list) throws SQLException {

<<<<<<< HEAD
        serviceDao.setImportServices(DbConnector.getIstance().getConnection(), list);
=======
        serviceDao.setImportServices(dbConnector.getConnection(), list);
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

    @Override
    public List<Service> getServices() throws SQLException {

<<<<<<< HEAD
        return serviceDao.getAll(DbConnector.getIstance().getConnection(), "zero");
=======
        return serviceDao.getAll(dbConnector.getConnection(), "zero");
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

    @Override
    public void createService(Integer price, String category) throws SQLException {

<<<<<<< HEAD
        serviceDao.create(DbConnector.getIstance().getConnection(), serviceDao.getMiracleService(price, category));
=======
        serviceDao.create(dbConnector.getConnection(), serviceDao.getMiracleService(price, category));
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

    @Override
    public Service getService(Integer serviceId) throws SQLException {

<<<<<<< HEAD
        return serviceDao.getById(DbConnector.getIstance().getConnection(), serviceId);
=======
        return serviceDao.getById(dbConnector.getConnection(), serviceId);
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

    @Override
    public void changeServicePrice(Integer id, Integer price) throws SQLException {

<<<<<<< HEAD
        serviceDao.changePrice(DbConnector.getIstance().getConnection(), id, price);
=======
        serviceDao.changePrice(dbConnector.getConnection(), id, price);
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }
}
