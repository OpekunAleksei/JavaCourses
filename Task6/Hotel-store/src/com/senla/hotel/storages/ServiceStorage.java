/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.storages;

import com.senla.hotel.entity.Service;
import com.senla.hotel.utils.ListRefresher;
import com.senla.hotel.utils.Serialization;
import com.senla.hotel.utils.TextWorker;
import com.senla.hotel.utils.Transfer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServiceStorage {

    private final Serialization serialization;
    private final ListRefresher listRefresher;
    private List<Service> service;
    private final Transfer transfer;
    private String path;
    private static ServiceStorage serviceStorage;
    private final TextWorker textWorker;
    private ServiceStorage() {
        textWorker = new TextWorker();
        transfer = new Transfer();
        serialization = new Serialization();
        listRefresher = new ListRefresher();
        this.service = new ArrayList<>();
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static ServiceStorage getInstance() {
        if (serviceStorage == null) {
            serviceStorage = new ServiceStorage();
        }
        return serviceStorage;
    }

    public void deserializeData() {
        Object deserializeData = serialization.deSerialize(this.path);
        if (deserializeData != null) {
            this.service = (ArrayList<Service>) deserializeData;
        }
    }

    public Integer getIdByNumberOnList(Integer number) {
        return service.get(number).getId();
    }

    public void serializeData() {
        serialization.serializeService(path, service);
    }

    public List<Service> getServices() {
        return service;
    }

    public void setService(Integer price, String category, Integer id) {
        if (price != null && id != null) {

            service = (ArrayList<Service>) listRefresher.refreshService(new Service(price, category, id), service);
        }
    }

    public void importServices(String path) throws IOException {
        List<String> list = transfer.importData(path); 
        for (int i = 1; i < list.size(); i++) {
            service = listRefresher.refreshService(new Service((String) list.get(i)), service);
        }
    }

    public void exportServices(String path) throws IOException {
        transfer.exportServiceData(path,textWorker.CreateServiceList(service) );
    }

    public Service getService(Integer serviceId) {
        return this.service.get(getServiceById(serviceId));
    }

    public void changeServicePrice(Integer id, Integer price) {
        this.service.get(getServiceById(id)).setPrice(price);
    }

    public Integer getServiceById(Integer id) {

        for (int i = 0; i < this.service.size(); i++) {
            if (this.service.get(i).getId().equals(id)) {
                return i;
            }
        }
        return null;
    }
}
