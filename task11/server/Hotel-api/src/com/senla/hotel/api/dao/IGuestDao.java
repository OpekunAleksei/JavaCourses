/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.dao;

import com.senla.hotel.entity.Guest;
import java.util.Date;
import java.util.List;

public interface IGuestDao extends IGenericDao<Guest> {

    public void setImportGuests(List<Guest> list);

    public Integer getIdByNumberOnlist(Integer number);

    public Guest createMiracleGuest(String name, Date arrivalDate, Date dateOfDeparture);

    public List<Guest> getById(List<Integer> id);
}
