/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.dao;

import com.senla.hotel.entity.Service;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;

public interface IServiceDao extends IGenericDao<Service> {

    public Integer getIdByNumberOnlist(Session session, Integer number) throws SQLException;

    public void setImportServices(Session session, List<Service> list) throws SQLException;

    public void changePrice(Session session, Integer id, Integer price) throws SQLException;

    public Service getMiracleService(Integer price, String category) throws SQLException;

}
