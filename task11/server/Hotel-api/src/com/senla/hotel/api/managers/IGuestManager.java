/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.managers;

import com.senla.hotel.entity.Guest;
import java.sql.SQLException;

import java.util.Date;
import java.util.List;

public interface IGuestManager {

    public void setImpotrGuests(List<Guest> list) throws SQLException;

    public Integer getIdByNumberOnList(Integer number) throws SQLException;

    public void createGuest(String name, Date arrivalDate, Date dateOfDeparture) throws SQLException;

    public Guest getGuestByID(Integer id) throws SQLException;

    public List<Guest> getListOfGuest(String name) throws SQLException;

}
