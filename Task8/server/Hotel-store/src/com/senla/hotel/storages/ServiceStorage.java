/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.storages;

import com.senla.hotel.api.storages.IServiceStorage;
import com.senla.hotel.entity.Service;
import com.senla.hotel.utils.ListRefresher;
import com.senla.hotel.utils.Serialization;
import java.util.ArrayList;
import java.util.List;

public class ServiceStorage implements IServiceStorage {

    private final Serialization serialization;
    private final ListRefresher listRefresher;
    private List<Service> service;

    private String path;
    private static ServiceStorage serviceStorage;

    private ServiceStorage() {

        serialization = new Serialization();
        listRefresher = new ListRefresher();
        this.service = new ArrayList<>();
    }

    public static IServiceStorage getInstance() {
        if (serviceStorage == null) {
            serviceStorage = new ServiceStorage() {};
        }
        return serviceStorage;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void deserializeData() {
        Object deserializeData = serialization.deSerialize(this.path);
        if (deserializeData != null) {
            this.service = (List<Service>) deserializeData;
        }
    }

    @Override
    public Integer getIdByNumberOnList(Integer number) {
        return service.get(number).getId();
    }

    @Override
    public void serializeData() {
        serialization.serializeEntity(path, service);
    }

    @Override
    public List<Service> getServices() {
        return service;
    }

    @Override
    public void setService(Integer price, String category, Integer id) {
        if (price != null && id != null) {

            service = (List<Service>) listRefresher.refreshService(new Service(price, category, id), service);
        }
    }

    @Override
    public void setImportServices(List<Service> list) {
        for (int i = 0; i < list.size(); i++) {
            service = listRefresher.refreshService(list.get(i), service);
        }
    }

    @Override
    public Service getService(Integer serviceId) {
        return this.service.get(getServiceById(serviceId));
    }

    @Override
    public void changeServicePrice(Integer id, Integer price) {
        this.service.get(getServiceById(id)).setPrice(price);
    }

    @Override
    public Integer getServiceById(Integer id) {

        for (int i = 0; i < this.service.size(); i++) {
            if (this.service.get(i).getId().equals(id)) {
                return i;
            }
        }
        return null;
    }
}
