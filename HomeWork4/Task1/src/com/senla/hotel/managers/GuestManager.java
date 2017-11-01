/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.managers;

import com.senla.hotel.entity.Guest;
import com.senla.hotel.comparators.GuestComparator;
import com.senla.hotel.storages.GuestStorage;
import java.text.ParseException;
import java.util.Arrays;

public class GuestManager {

    private GuestStorage guestStorage;

    public GuestManager(String path) {
        guestStorage = new GuestStorage(path);
    }

    public void createGuest() throws ParseException {
        guestStorage.createGuest();
    }

    public Guest getGuest(Integer id) {
        return guestStorage.getGuest(id);
    }

    public String getSortGuestByName() {
        Arrays.sort(guestStorage.getArrayGuest(), new GuestComparator().getNameComparator());
        return guestStorage.getLisOfGuest();
    }

    public String getSortGuestByDateOfDeparture() {
        Arrays.sort(guestStorage.getArrayGuest(), new GuestComparator().getDateComparator());
        return guestStorage.getLisOfGuest();
    }

}
