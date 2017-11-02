/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.managers;

import com.senla.hotel.entity.Service;
import com.senla.hotel.storages.ServiceStorage;

public class ServiceManager {

    ServiceStorage serviceStorage;

    public ServiceManager(String path) {
        serviceStorage = new ServiceStorage(path);
    }

    public void writeToServiceFile(String[] array) {
        serviceStorage.writeToServiceFile(array);
    }

    public void createService() {
        serviceStorage.setService();
    }

    public Service getService(Integer serviceId) {
        return serviceStorage.getService(serviceId);
    }

    public void changeServicePrice(String serviceCategory, Integer price) {
        serviceStorage.changeServicePrice(serviceCategory, price);
    }
}
