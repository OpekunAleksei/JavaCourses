/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.managers;

import com.senla.hotel.entity.Service;
import com.senla.hotel.storages.ServiceStorage;
import java.io.IOException;

public class ServiceManager {

    ServiceStorage serviceStorage;

    public ServiceManager(String path) {
        serviceStorage = new ServiceStorage(path);
    }

    public void deserializeData() {
        serviceStorage.deserializeData();

    }

    public void serializeData() {
        serviceStorage.serializeData();
    }

    public Integer getIdByNumberOnList(Integer number) {
        return serviceStorage.getIdByNumberOnList(number);
    }

    public void importServices(String path) throws IOException {
        serviceStorage.importServices(path);
    }

    public void exportServices(String path) throws IOException {
        serviceStorage.exportServices(path);
    }

    public String getListOfServices() {
        return serviceStorage.getListOfServices();
    }

    public void createService(Integer price, String category, Integer id) {
        serviceStorage.setService(price, category, id);
    }

    public Service getService(Integer serviceId) {
        return serviceStorage.getService(serviceId);
    }

    public void changeServicePrice(Integer id, Integer price) {
        serviceStorage.changeServicePrice(id, price);
    }
}
