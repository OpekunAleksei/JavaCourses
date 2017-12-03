/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.managers;

import com.senla.hotel.entity.Service;
import com.senla.hotel.storages.ServiceStorage;
import java.io.IOException;
import java.util.List;

public class ServiceManager {

    public ServiceManager(String path) {
        ServiceStorage.getInstance().setPath(path);
    }

    public void deserializeData() {
        ServiceStorage.getInstance().deserializeData();

    }
   public void serializeData() {
        ServiceStorage.getInstance().serializeData();
    }

    public Integer getIdByNumberOnList(Integer number) {
        return ServiceStorage.getInstance().getIdByNumberOnList(number);
    }

    public void importServices(String path) throws IOException {
        ServiceStorage.getInstance().importServices(path);
    }

    public void exportServices(String path) throws IOException {
        ServiceStorage.getInstance().exportServices(path);
    }

    public List<Service> getServices() {
        return ServiceStorage.getInstance().getServices();
    }

    public void createService(Integer price, String category, Integer id) {
        ServiceStorage.getInstance().setService(price, category, id);
    }

    public Service getService(Integer serviceId) {
        return ServiceStorage.getInstance().getService(serviceId);
    }

    public void changeServicePrice(Integer id, Integer price) {
        ServiceStorage.getInstance().changeServicePrice(id, price);
    }
}
