/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.managers;

import com.senla.hotel.entity.Guest;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;

import java.util.Date;
import java.util.List;

public interface IHistoryManager {

    public void settleInRoom(Guest guest, Room room) throws Exception;

    public void evictedFromRoom(Guest guest, Room room) throws Exception;

    public void addServiceToGuest(Service service, Guest guest, Room room) throws Exception;

    public Long getGuestPriceForAccommodation(Guest guest, Room room) throws Exception;

    public Integer getNumberGuestInHotel() throws Exception;

    public List<Guest> getListLeftGuestThisRoom(Room room, Integer count) throws Exception;

    public List<Room> getListOfRoomsAvailableByDate(Date date) throws Exception;

    public List<Service> getGuestServices(Guest guest, Room room, String sort) throws Exception;

}
