/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.storages;

import com.senla.hotel.entity.Service;
import java.util.List;

public interface IServiceStorage {

    public void setPath(String path);

    public void deserializeData();

    public Integer getIdByNumberOnList(Integer number);

    public void serializeData();

    public List<Service> getServices();

    public void setService(Integer price, String category, Integer id);

    public void setImportServices(List<Service> list);

    public Service getService(Integer serviceId);

    public void changeServicePrice(Integer id, Integer price);

    public Integer getServiceById(Integer id);
}
