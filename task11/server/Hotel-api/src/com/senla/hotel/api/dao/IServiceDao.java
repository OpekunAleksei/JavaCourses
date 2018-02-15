/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.dao;

import com.senla.hotel.entity.Service;
import java.util.List;

public interface IServiceDao extends IGenericDao<Service> {

    public Integer getIdByNumberOnlist(Integer number);

    public void setImportServices(List<Service> list);

    public void changePrice(Integer id, Integer price);

    public Service getMiracleService(Integer price, String category);

    public List<Service> getById(List<Integer> id);
}
