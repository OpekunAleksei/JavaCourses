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

    public final IServiceDao serviceDao = new ServiceDaoImpl();

    public ServiceManager() {

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

        return serviceDao.getAll();
    }

    @Override
    public void createService(Integer price, String category) {
        Service service = new Service(price, category, null);
        serviceDao.create(service);

    }

    @Override
    public Service getService(Integer serviceId) {
        return serviceDao.getByID(serviceId);
    }

    @Override
    public void changeServicePrice(Integer id, Integer price) {
        serviceDao.changePrice(id, price);

    }
}
