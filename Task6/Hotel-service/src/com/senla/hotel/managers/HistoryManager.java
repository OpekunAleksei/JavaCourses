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

    private final HistoryStorage historyStorage;

    public HistoryManager(String path) {
        historyStorage = new HistoryStorage(path);
    }

    public void deserializeData() {
        historyStorage.deserializeData();

    }

    public void serializeData() {
        historyStorage.serializeData();
    }

    public void settleInRoom(Guest guest, Room room) {

        historyStorage.settleInRoom(guest, room);
    }

    public void evictedFromRoom(Guest guest, Room room) {

        historyStorage.evictedFromRoom(guest, room);
    }

    public void addServiceToGuest(Service service, Guest guest, Room room) {
        historyStorage.addServiceToGuest(service, guest, room);
    }

    public Integer getGuestPriceForAccommodation(Guest guest, Room room) {
        return historyStorage.getGuestPriceForAccommodation(guest, room);
    }

    public Integer getNumberGuestInHotel() {
        return historyStorage.getNumberGuestInHotel();
    }

    public Boolean checkForPresenceGuestsInRoom(Room room) {

        return historyStorage.checkForPresenceGuestsInRoom(room);
    }

    public String getListLeftGuestThisRoom(Room room, Integer count) {
        return historyStorage.getListLeftGuestThisRoom(room, count);
    }

    public String getListOfRoomsAvailableByDate(Date date, List<Room> list) {
        return historyStorage.getListOfRoomsAvailableByDate(date, list);
    }

    public String sorting(Guest guest, Comparator comparator, Room room) {
        List aList = historyStorage.getGuestServices(guest, room);
        Collections.sort(aList, comparator);
        return historyStorage.getListOfGuestService(guest, room);
    }

}
