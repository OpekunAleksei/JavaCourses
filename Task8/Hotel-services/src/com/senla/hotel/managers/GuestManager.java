/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.managers;

import com.senla.hotel.entity.Guest;
import com.senla.hotel.storages.GuestStorage;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import com.senla.hotel.api.managers.IGuestManager;

public class GuestManager implements IGuestManager {

    public GuestManager(String path) {
        GuestStorage.getInstance().setPath(path);
    }

    @Override
    public void setImpotrGuests(List<Guest> list) {
        GuestStorage.getInstance().setImportGuests(list);
    }

    @Override
    public Integer getIdByNumberOnList(Integer number) {
        return GuestStorage.getInstance().getIdByNumberOnList(number);
    }

    @Override
    public void createGuest(String name, Date arrivalDate, Date dateOfDeparture, Integer id) {
        GuestStorage.getInstance().createGuest(name, arrivalDate, dateOfDeparture, id);
    }

    @Override
    public void serializeData() {
        GuestStorage.getInstance().serializeData();
    }

    @Override
    public void deserializeData() {
        GuestStorage.getInstance().deserializeData();
    }

    @Override
    public Guest getGuestByID(Integer id) {

        return GuestStorage.getInstance().getGuestById(id);
    }

    @Override
    public void sorting(Comparator comporator) {
        List list = GuestStorage.getInstance().getGuests();
        Collections.sort(list, comporator);
    }

    @Override
    public List<Guest> getGuests() {
        return GuestStorage.getInstance().getGuests();
    }
}
