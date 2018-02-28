/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.dao;

import com.senla.hotel.entity.Service;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IServiceDao extends IGenericDao<Service> {

    public Integer getIdByNumberOnlist(Connection connection, Integer number) throws SQLException;

    public void setImportServices(Connection connection, List<Service> list) throws SQLException;

    public void changePrice(Connection connection, Integer id, Integer price) throws SQLException;

    public Service getMiracleService(Integer price, String category) throws SQLException;

    public List<Service> getById(Connection connection, List<Integer> id) throws SQLException;
}
