/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.storages;

import com.senla.hotel.entity.Guest;
import java.util.Date;
import java.util.List;

public interface IGuestStorage {

    public List<Guest> getGuests();

    public void setPath(String path);

    public Integer getIdByNumberOnList(Integer number);

    public void createGuest(String name, Date arrivalDate, Date dateOfDeparture, Integer id);

    public void setImportGuests(List<Guest> list);

    public void serializeData();

    public void deserializeData();

    public Guest getGuestById(Integer id);


}
