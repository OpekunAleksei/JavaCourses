/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.managers;

import com.senla.hotel.entity.Service;
import java.sql.SQLException;
import java.util.List;

public interface IServiceManager {

    public Integer getIdByNumberOnList(Integer number) throws SQLException;

    public void setImportServices(List<Service> list) throws SQLException;

    public List<Service> getServices() throws SQLException;

    public void createService(Integer price, String category) throws SQLException;

    public Service getService(Integer serviceId) throws SQLException;

    public void changeServicePrice(Integer id, Integer price) throws SQLException;
}
