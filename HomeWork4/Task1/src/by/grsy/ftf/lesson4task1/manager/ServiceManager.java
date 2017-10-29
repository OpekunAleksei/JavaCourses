/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grsy.ftf.lesson4task1.manager;

import by.grsy.ftf.lesson4task1.entity.Service;
import by.grsy.ftf.lesson4task1.storage.ServiceStorage;
public class ServiceManager {

    ServiceStorage serviceStorage;
    public ServiceManager() {
        serviceStorage = new ServiceStorage();
    }

    public void createService(Service service) {
        serviceStorage.setService(service);
    }

    public Service getService(Service service) {
        return serviceStorage.getService(service);
    }

    public void changeServicePrice(Service service, Integer price) {
        serviceStorage.changeServicePrice(service, price);
    }

    public Service createRoo(String a) {
        return serviceStorage.getid(a);
    }
}
