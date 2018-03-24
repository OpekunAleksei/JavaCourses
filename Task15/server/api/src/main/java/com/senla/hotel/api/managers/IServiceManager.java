/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.managers;

import com.senla.hotel.entity.Service;
import java.util.List;

public interface IServiceManager {

    public Integer getIdByNumberOnList(Integer number) throws Exception;

    public void setImportServices(List<Service> list) throws Exception;

    public List<Service> getServices() throws Exception;

    public void createService(Service service) throws Exception;

    public Service getService(Integer serviceId) throws Exception;

    public void changeServicePrice(Integer id, Integer price) throws Exception;
}
