/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.storages;

import com.senla.hotel.api.storages.IGuestStorage;
import com.senla.hotel.entity.Guest;
import com.senla.hotel.utils.ListRefresher;
import com.senla.hotel.utils.Serialization;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class GuestStorage implements IGuestStorage {

    private final ListRefresher listRefresher;
    private List<Guest> guest;
    private String path;
    private final Serialization serialization;
    private static GuestStorage guestStorage;

    private GuestStorage() {
        serialization = new Serialization();
        listRefresher = new ListRefresher();
        this.guest = new ArrayList<>();
    }

    public static IGuestStorage getInstance() {
        if (guestStorage == null) {
            guestStorage = new GuestStorage();
        }
        return guestStorage;
    }

    @Override
    public List<Guest> getGuests() {
    
        return guest;
    }

    @Override
    public void setPath(String path) {
        this.path = path;

    }

    @Override
    public Integer getIdByNumberOnList(Integer number) {
        return guest.get(number).getId();
    }

    @Override
    public void createGuest(String name, Date arrivalDate, Date dateOfDeparture, Integer id) {
 
        guest = listRefresher.refreshGuest(new Guest(name, arrivalDate, dateOfDeparture, id), guest);
             
    }
@Override
    public void setImportGuests(List<Guest> list) {

        for (int i = 0; i < list.size(); i++) {
            guest = listRefresher.refreshGuest(list.get(i), guest);
        }
    }
@Override
    public void serializeData() {
        serialization.serializeGuest(this.path, this.guest);
    }
@Override
    public void deserializeData() {
        Object deserializeData = serialization.deSerialize(this.path);
        if (deserializeData != null) {
            this.guest = (ArrayList<Guest>) deserializeData;
        }
    }

    @Override
    public Guest getGuestById(Integer id) {

        return this.guest.get(getItemNumberOfGuestById(id));
    }

    private Integer getItemNumberOfGuestById(Integer id) {
        for (int i = 0; i < this.guest.size(); i++) {
            if (Objects.equals(this.guest.get(i).getId(), id) == true) {
                return i;
            }

        }
        return null;
    }
}
