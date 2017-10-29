/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grsy.ftf.lesson4task1.storage;

import by.grsy.ftf.lesson4task1.entity.Service;

public class ServiceStorage {
    private Service service[];
    private Integer counter;

    public ServiceStorage() {
        service = new Service[100];
        this.counter = 0;
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

    public void setService(Service service) {
        this.service[this.counter] = new Service(null);
        this.service[this.counter] = service;
        this.counter++;
    }

    public Service getService(Service service) {
        return this.service[getNumberOfSrvice(service)];
    }

    public void changeServicePrice(Service service, Integer price) {
        this.service[getNumberOfSrvice(service)].setPrice(price);
    }

    public Service getid(String n) {
        int k = 0;
        for (int i = 0; i < this.counter; i++) {
            if (this.service[i].getCategory().equals(n)) {
                k = i;
            }
        }
        return service[k];
    }

}
