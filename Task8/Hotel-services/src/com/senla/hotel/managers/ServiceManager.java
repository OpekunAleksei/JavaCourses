/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.managers;

import com.senla.hotel.entity.Service;
import com.senla.hotel.storages.ServiceStorage;
import java.util.List;
import com.senla.hotel.api.managers.IServiceManager;

public class ServiceManager implements IServiceManager {

    public ServiceManager(String path) {
        ServiceStorage.getInstance().setPath(path);
    }

    @Override
    public void deserializeData() {
        ServiceStorage.getInstance().deserializeData();

    }

    @Override
    public void serializeData() {
        ServiceStorage.getInstance().serializeData();
    }

    @Override
    public Integer getIdByNumberOnList(Integer number) {
        return ServiceStorage.getInstance().getIdByNumberOnList(number);
    }

    @Override
    public void setImportServices(List<Service> list) {
        ServiceStorage.getInstance().setImportServices(list);
    }

    @Override
    public List<Service> getServices() {
        return ServiceStorage.getInstance().getServices();
    }

    @Override
    public void createService(Integer price, String category, Integer id) {
        ServiceStorage.getInstance().setService(price, category, id);
    }

    @Override
    public Service getService(Integer serviceId) {
        return ServiceStorage.getInstance().getService(serviceId);
    }

    @Override
    public void changeServicePrice(Integer id, Integer price) {
        ServiceStorage.getInstance().changeServicePrice(id, price);
    }
}
