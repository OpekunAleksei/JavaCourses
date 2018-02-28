/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.dao;

import com.senla.hotel.entity.Guest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IGuestDao extends IGenericDao<Guest> {

    public void setImportGuests(Connection connection, List<Guest> list) throws SQLException;

    public Integer getIdByNumberOnlist(Connection connection, Integer number) throws SQLException;

    public Guest createMiracleGuest(String name, Date arrivalDate, Date dateOfDeparture);

}
