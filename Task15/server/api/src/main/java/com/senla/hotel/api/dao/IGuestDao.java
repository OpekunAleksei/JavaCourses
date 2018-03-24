/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.dao;

import com.senla.hotel.entity.Guest;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;

public interface IGuestDao extends IGenericDao<Guest> {

    public void setImportGuests(Session session, List<Guest> list) throws SQLException;

    public Integer getIdByNumberOnlist(Session session, Integer number) throws SQLException;



}
