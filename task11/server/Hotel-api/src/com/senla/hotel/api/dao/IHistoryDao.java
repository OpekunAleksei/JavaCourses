/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.dao;

import com.senla.hotel.entity.Guest;
import com.senla.hotel.entity.History;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;
import java.util.Date;
import java.util.List;

public interface IHistoryDao {

    public void create(History history);

    public void evictedFromRoom(History history);

    public void setService(Guest guest, Room room, Service service);

    public Integer getPriceForAccommodation(Guest guest, Room room);

    public Integer getNumberOfGuestInHotel();

    public Boolean checForPresense(Room room);

    public List<Integer> getListLeftGuest(Room room, Integer count);

    public List<Integer> getIdRoomsAvalableByDate(Date date);

    public List<Integer> getIdSortingServices(Room room, Guest guest, String sort);

    public History getMiracleHistory(Guest guest, Room room);

}
