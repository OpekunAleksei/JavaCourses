/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.managers;

import com.senla.hotel.entity.Service;
import java.util.List;

public interface IServiceManager {


    public Integer getIdByNumberOnList(Integer number);

    public void setImportServices(List<Service> list);

    public List<Service> getServices();

    public void createService(Integer price, String category);

    public Service getService(Integer serviceId);

    public void changeServicePrice(Integer id, Integer price);
}
