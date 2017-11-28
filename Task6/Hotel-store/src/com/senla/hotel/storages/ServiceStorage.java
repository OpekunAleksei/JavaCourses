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

    private final Serialization serialization ;
    private final ListRefresher listRefresher ;
    private List<Service> service;
    private final Transfer transfer;
    private final String path;

    public ServiceStorage(String path) {
        transfer = new Transfer();
        serialization = new Serialization();
        listRefresher = new ListRefresher();
        this.service = new ArrayList<>();
        this.path = path;
    }

    public void deserializeData() {
        if (serialization.deSerialize(path) != null) {
            this.service = (ArrayList<Service>) serialization.deSerialize(path);
        }
    }

    public Integer getIdByNumberOnList(Integer number) {
        return service.get(number).getId();
    }

    public void serializeData() {
        serialization.serializeService(path, service);
    }

    public String getListOfServices() {
        TextWorker textWorker = new TextWorker();
        textWorker.CreateServiceList(service);
        return textWorker.getList();
    }

    public void setService(Integer price, String category, Integer id) {
        if (price != null && id != null) {

            service = (ArrayList<Service>) listRefresher.refreshService(new Service(price, category, id), service);
        }
    }
    public void importServices(String path) throws IOException {
        for (int i = 1; i < transfer.importData(path).size(); i++) {
            service = listRefresher.refreshService(new Service((String) transfer.importData(path).get(i)), service);
        }
    }
        public void exportServices(String path) throws IOException {
        transfer.exportServiceData(path,getListOfServices());
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
