/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.managers;

import com.senla.hotel.entity.Guest;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;
import java.sql.SQLException;

import java.util.Date;
import java.util.List;

public interface IHistoryManager {

    public void settleInRoom(Guest guest, Room room) throws SQLException;

    public void evictedFromRoom(Guest guest, Room room) throws SQLException;

    public void addServiceToGuest(Service service, Guest guest, Room room) throws SQLException;

    public Integer getGuestPriceForAccommodation(Guest guest, Room room) throws SQLException;

    public Integer getNumberGuestInHotel() throws SQLException;

    public Boolean checkForPresenceGuestsInRoom(Room room) throws SQLException;

    public List<Guest> getListLeftGuestThisRoom(Room room, Integer count) throws SQLException;

    public List<Room> getListOfRoomsAvailableByDate(Date date, List<Room> list) throws SQLException;

    public List<Service> getGuestServices(Guest guest, Room room, String sort) throws SQLException;

}
