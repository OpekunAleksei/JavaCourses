/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.storages;

import com.senla.hotel.entity.Service;
import com.senla.hotel.utils.FileWorker;
import java.util.ArrayList;

public class ServiceStorage {

    private ArrayList<Service> service;
    private static Integer counter = 0;
    private String path;
    private FileWorker fileWorker;

    public ServiceStorage(String path) {
        this.service = new ArrayList<>();

        if (path == null) {
            path = "D:\\serviceFile.txt";
        }
        this.path = path;
        this.fileWorker = new FileWorker();
    }

    public void writeToServiceFile(String[] array) {

        fileWorker.writeToServiceFile(this.path, array);
    }

    public Integer getNumberOfSrviceByCategory(String serviceCategory) {
        Integer serviceNumber = 0;
        Integer test = null;
        for (int i = 0; i < this.service.size(); i++) {
            if (this.service.get(i).getCategory().equals(serviceCategory)) {
                serviceNumber = i;
                test = i;
            }
        }
        if (test != null) {
            return serviceNumber;
        } else {
            return test;
        }

    }

    public void setService() {
        this.fileWorker.readFromFile(path);
        if (fileWorker.readFromFile(path)[counter].equalsIgnoreCase("null") == false) {
            this.service.add(new Service(fileWorker.readFromFile(path)[counter]));
            counter++;
        }

        if (this.service.get(this.service.size() - 1).getId() == null) {
            this.service.remove(this.service.size() - 1);
        }
    }

    public Service getService(Integer serviceId) {
        return this.service.get(getServiceById(serviceId));
    }

    public void changeServicePrice(String serviceCategory, Integer price) {
        this.service.get(getNumberOfSrviceByCategory(serviceCategory)).setPrice(price);
    }

    public Integer getServiceById(Integer id) {
        Integer number = 0;
        Integer test = null;
        for (int i = 0; i < this.service.size(); i++) {
            if (this.service.get(i).getId().equals(id)) {//nenujno
                number = i;
                test = i;
            }

        }
        if (test != null) {
            return number;
        } else {
            return test;
        }
    }
}
