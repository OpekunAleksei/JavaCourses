/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.managers;

import com.senla.hotel.entity.Service;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Guest;
import com.senla.hotel.storages.HistoryStorage;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class HistoryManager {

    public HistoryManager(String path) {
        HistoryStorage.getInstance().setPath(path);
    }

    public void deserializeData() {
        HistoryStorage.getInstance().deserializeData();

    }

    public void serializeData() {
        HistoryStorage.getInstance().serializeData();
    }

    public void settleInRoom(Guest guest, Room room) {

        HistoryStorage.getInstance().settleInRoom(guest, room);
    }

    public void evictedFromRoom(Guest guest, Room room) {

        HistoryStorage.getInstance().evictedFromRoom(guest, room);
    }

    public void addServiceToGuest(Service service, Guest guest, Room room) {
        HistoryStorage.getInstance().addServiceToGuest(service, guest, room);
    }

    public Integer getGuestPriceForAccommodation(Guest guest, Room room) {
        return HistoryStorage.getInstance().getGuestPriceForAccommodation(guest, room);
    }

    public Integer getNumberGuestInHotel() {
        return HistoryStorage.getInstance().getNumberGuestInHotel();
    }

    public Boolean checkForPresenceGuestsInRoom(Room room) {

        return HistoryStorage.getInstance().checkForPresenceGuestsInRoom(room);
    }

    public List<Guest> getListLeftGuestThisRoom(Room room, Integer count) {
        return HistoryStorage.getInstance().getListLeftGuestThisRoom(room, count);
    }

    public List<Room> getListOfRoomsAvailableByDate(Date date, List<Room> list) {
        return HistoryStorage.getInstance().getListOfRoomsAvailableByDate(date, list);
    }

    public List<Service> getGuestServices(Guest guest, Room room) {
        return HistoryStorage.getInstance().getGuestServices(guest, room);
    }

    public void sorting(Guest guest, Comparator comparator, Room room) {
        List aList = HistoryStorage.getInstance().getGuestServices(guest, room);
        Collections.sort(aList, comparator);

    }

}
