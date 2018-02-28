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


    public ServiceManager() {
        this.serviceDao = new ServiceDaoImpl();

    }

    @Override
    public Integer getIdByNumberOnList(Integer number) throws SQLException {

        return serviceDao.getIdByNumberOnlist(DbConnector.getIstance().getConnection(), number);

    }

    @Override
    public void setImportServices(List<Service> list) throws SQLException {

        serviceDao.setImportServices(DbConnector.getIstance().getConnection(), list);

    }

    @Override
    public List<Service> getServices() throws SQLException {

        return serviceDao.getAll(DbConnector.getIstance().getConnection(), "zero");

    }

    @Override
    public void createService(Integer price, String category) throws SQLException {

        serviceDao.create(DbConnector.getIstance().getConnection(), serviceDao.getMiracleService(price, category));

    }

    @Override
    public Service getService(Integer serviceId) throws SQLException {

        return serviceDao.getById(DbConnector.getIstance().getConnection(), serviceId);

    }

    @Override
    public void changeServicePrice(Integer id, Integer price) throws SQLException {

        serviceDao.changePrice(DbConnector.getIstance().getConnection(), id, price);

    }
}
