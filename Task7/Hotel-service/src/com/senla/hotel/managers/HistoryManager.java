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
import com.senla.hotel.api.managers.IHistoryManager;

public class HistoryManager implements IHistoryManager {

    public HistoryManager(String path) {
        HistoryStorage.getInstance().setPath(path);
    }

    @Override
    public void deserializeData() {
        HistoryStorage.getInstance().deserializeData();

    }

    @Override
    public void serializeData() {
        HistoryStorage.getInstance().serializeData();
    }

    @Override
    public void settleInRoom(Guest guest, Room room) {

        HistoryStorage.getInstance().settleInRoom(guest, room);
    }

    @Override
    public void evictedFromRoom(Guest guest, Room room) {

        HistoryStorage.getInstance().evictedFromRoom(guest, room);
    }

    @Override
    public void addServiceToGuest(Service service, Guest guest, Room room) {
        HistoryStorage.getInstance().addServiceToGuest(service, guest, room);
    }

    @Override
    public Integer getGuestPriceForAccommodation(Guest guest, Room room) {
        return HistoryStorage.getInstance().getGuestPriceForAccommodation(guest, room);
    }

    @Override
    public Integer getNumberGuestInHotel() {
        return HistoryStorage.getInstance().getNumberGuestInHotel();
    }

    @Override
    public Boolean checkForPresenceGuestsInRoom(Room room) {

        return HistoryStorage.getInstance().checkForPresenceGuestsInRoom(room);
    }

    @Override
    public List<Guest> getListLeftGuestThisRoom(Room room, Integer count) {
        return HistoryStorage.getInstance().getListLeftGuestThisRoom(room, count);
    }

    @Override
    public List<Room> getListOfRoomsAvailableByDate(Date date, List<Room> list) {
        return HistoryStorage.getInstance().getListOfRoomsAvailableByDate(date, list);
    }

    @Override
    public List<Service> getGuestServices(Guest guest, Room room) {
        return HistoryStorage.getInstance().getGuestServices(guest, room);
    }

    @Override
    public void sorting(Guest guest, Comparator comparator, Room room) {
        List aList = HistoryStorage.getInstance().getGuestServices(guest, room);
        Collections.sort(aList, comparator);

    }

}
