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

public class ServiceManager implements IServiceManager {

    private final IServiceDao serviceDao;

    public ServiceManager() {
        this.serviceDao = new ServiceDaoImpl();

    }

    @Override
    public Integer getIdByNumberOnList(Integer number) {
        return serviceDao.getIdByNumberOnlist(number);
    }

    @Override
    public void setImportServices(List<Service> list) {
        serviceDao.setImportServices(list);

    }

    @Override
    public List<Service> getServices() {

        return serviceDao.getAll(null);
    }

    @Override
    public void createService(Integer price, String category) {
        serviceDao.create(serviceDao.getMiracleService(price, category));

    }

    @Override
    public Service getService(Integer serviceId) {
        return serviceDao.getById(serviceId);
    }

    @Override
    public void changeServicePrice(Integer id, Integer price) {
        serviceDao.changePrice(id, price);

    }
}
