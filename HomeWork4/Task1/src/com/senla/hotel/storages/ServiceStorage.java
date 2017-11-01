/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.storages;

import com.senla.hotel.entity.Service;

public class ServiceStorage {

    private Service service[];
    private Integer counter;
    private String path;

    public ServiceStorage(String path) {
        service = new Service[100];
        this.counter = 0;
        this.path = path;
    }

    public Integer getNumberOfSrvice(Service service) {
        int serviceNumber = 0;
        for (int i = 0; i < this.counter; i++) {
            if (this.service[i].getId().equals(service.getId())) {
                serviceNumber = i;
            }
        }
        return serviceNumber;
    }

    public Integer getNumberOfSrviceByCategory(String serviceCategory) {
        int serviceNumber = 0;
        for (int i = 0; i < this.counter; i++) {
            if (this.service[i].getCategory().equals(serviceCategory)) {
                serviceNumber = i;
            }
        }
        return serviceNumber;
    }

    public void setService() {
        this.service[this.counter] = new Service(this.path);
        this.counter++;
    }

    public Service getService(Integer serviceId) {
        return this.service[getServiceById(serviceId)];
    }

    public void changeServicePrice(String serviceCategory, Integer price) {
        this.service[getNumberOfSrviceByCategory(serviceCategory)].setPrice(price);
    }

    public Integer getServiceById(Integer id) {
        int number = 0;
        for (int i = 0; i < this.counter; i++) {
            if (this.service[i].getId().equals(id)) {//nenujno
                number = i;
            }
        }
        return number;
    }

}
