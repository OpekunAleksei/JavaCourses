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

    public GuestManager(String path) {
        GuestStorage.getInstance().setPath(path);
    }

    public void importGuests(String path) throws IOException, ParseException {
        GuestStorage.getInstance().importGuests(path);
    }

    public void exportGuests(String path) throws IOException {
        GuestStorage.getInstance().exportGuests(path);
    }

    public Integer getIdByNumberOnList(Integer number) {
        return GuestStorage.getInstance().getIdByNumberOnList(number);
    }

    public void createGuest(String name, Date arrivalDate, Date dateOfDeparture, Integer id) throws ParseException {
        GuestStorage.getInstance().createGuest(name, arrivalDate, dateOfDeparture, id);
    }

    public void serializeData() {
        GuestStorage.getInstance().serializeData();
    }

    public void deserializeData() {
        GuestStorage.getInstance().deserializeData();
    }

    public Guest getGuestByID(Integer id) {

        return GuestStorage.getInstance().getGuestById(id);
    }

    public List<Guest> sorting(Comparator comporator) {
        List list = GuestStorage.getInstance().getGuests();
        Collections.sort(list, comporator);
        return GuestStorage.getInstance().getGuests();
    }

}
