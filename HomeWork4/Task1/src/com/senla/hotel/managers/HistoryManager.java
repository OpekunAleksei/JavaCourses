/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.managers;

import com.senla.hotel.entity.Service;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Guest;
import com.senla.hotel.comparators.ServiceComparator;
import com.senla.hotel.storages.HistoryStorage;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

public class HistoryManager {

    private HistoryStorage historyStorage;

    public HistoryManager() {
        historyStorage = new HistoryStorage();
    }

    public void settleInRoom(Guest guest, Room room) throws ParseException {

        historyStorage.settleInRoom(guest, room);
    }

    public void evictedFromRoom(Guest guest) throws ParseException {

        historyStorage.evictedFromRoom(guest);
    }

    public void addServiceToGuest(Service service, Guest guest) {
        historyStorage.addServiceToGuest(service, guest);
    }

    public Integer getGuestPriceForAccommodation(Guest guest) {
        return historyStorage.getGuestPriceForAccommodation(guest);
    }

    public Integer getNumberGuestInHotel() {
        return historyStorage.getNumberGuestInHotel();
    }

    public Boolean checkForPresenceGuestsInRoom(Room room) {

        return historyStorage.checkForPresenceGuestsInRoom(room);
    }

    public String getListLeftThreeGuestThisRoom(Room room) throws ParseException {
        return historyStorage.getListLeftGuestThisRoom(room);
    }

    public String getListOfRoomsAvailableByDate(Date date) {
        return historyStorage.getListOfRoomsAvailableByDate(date);
    }

    public String getGuestSortServiceByPrice(Guest guest) {
        Arrays.sort(historyStorage.getArrayGuestService(guest), new ServiceComparator().getServiceByPriceComparator());
        return historyStorage.getListOfGuestService(guest);
    }

    public String getSortListServiceGuestByCategory(Guest guest) {
        Arrays.sort(historyStorage.getArrayGuestService(guest), new ServiceComparator().getServiceByCategoryComparator());
        return historyStorage.getListOfGuestService(guest);
    }
}
