/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.managers;

import com.senla.hotel.entity.Guest;

import java.util.List;

public interface IGuestManager {

    public void setImpotrGuests(List<Guest> list) throws Exception;

    public Integer getIdByNumberOnList(Integer number) throws Exception;

    public void createGuest(Guest guest) throws Exception;

    public Guest getGuestByID(Integer id) throws Exception;

    public List<Guest> getListOfGuest(String name) throws Exception;

}
