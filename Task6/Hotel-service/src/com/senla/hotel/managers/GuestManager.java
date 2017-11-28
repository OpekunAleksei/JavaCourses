/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.managers;

import com.senla.hotel.entity.Guest;
import com.senla.hotel.storages.GuestStorage;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class GuestManager {

    private final GuestStorage guestStorage;

    public GuestManager(String path) {
        guestStorage = new GuestStorage(path);

    }

    public void importGuests(String path) throws IOException, ParseException {
        guestStorage.importGuests(path);
    }

    public void exportGuests(String path) throws IOException {
        guestStorage.exportGuests(path);
    }

    public Integer getIdByNumberOnList(Integer number) {
        return guestStorage.getIdByNumberOnList(number);
    }

    public void createGuest(String name, Date arrivalDate, Date dateOfDeparture, Integer id) throws ParseException {
        guestStorage.createGuest(name, arrivalDate, dateOfDeparture, id);
    }

    public void serializeData() {
        guestStorage.serializeData();
    }

    public void deserializeData() {
        guestStorage.deserializeData();
    }

    public Guest getGuestByID(Integer id) {

        return guestStorage.getGuestById(id);
    }

    public String sorting(Comparator comporator) {
        List list = guestStorage.getGuests();
        Collections.sort(list, comporator);
        return guestStorage.getLisOfGuest();
    }

}
