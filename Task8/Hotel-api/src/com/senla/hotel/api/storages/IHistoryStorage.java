/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.storages;

import com.senla.hotel.entity.Guest;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;
import java.util.Date;
import java.util.List;

public interface IHistoryStorage {

    public void setPath(String path);

    public void deserializeData();

    public void serializeData();

    public void addServiceToGuest(Service service, Guest guest, Room room);

    public void evictedFromRoom(Guest guest, Room room);

    public Integer getNumberGuestInHotel();

    public void settleInRoom(Guest guest, Room room);

    public List<Room> getListOfRoomsAvailableByDate(Date date, List<Room> rList);

    public List<Guest> getListLeftGuestThisRoom(Room room, Integer count);

    public Boolean checkForPresenceGuestsInRoom(Room room);

    public Integer getGuestPriceForAccommodation(Guest guest, Room room);

    public List<Service> getGuestServices(Guest guest, Room room);
}
