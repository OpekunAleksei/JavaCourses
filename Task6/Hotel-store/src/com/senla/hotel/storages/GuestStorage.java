/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.storages;

import com.senla.hotel.entity.Guest;
import com.senla.hotel.utils.Transfer;
import com.senla.hotel.utils.ListRefresher;
import com.senla.hotel.utils.Serialization;
import com.senla.hotel.utils.TextWorker;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class GuestStorage {

    private final TextWorker textWorker;
    private final ListRefresher listRefresher;
    private List<Guest> guest;
    private String path;
    private final Serialization serialization;
    private final Transfer transfer;
    private static GuestStorage guestStorage;

    private GuestStorage() {
        textWorker = new TextWorker();
        transfer = new Transfer();
        serialization = new Serialization();
        listRefresher = new ListRefresher();
        this.guest = new ArrayList<>();
    }
    public static GuestStorage getInstance() {
        if (guestStorage == null) {
            guestStorage = new GuestStorage();
        }
        return guestStorage;
    }

    public List<Guest> getGuests() {
        return guest;
    }

    public void setPath(String path) {
        this.path = path;

    }

    public void exportGuests(String path) throws IOException {
        transfer.exportGuestData(path, textWorker.CreateGuestList(guest));
    }

    public Integer getIdByNumberOnList(Integer number) {
        return guest.get(number).getId();
    }

    public void createGuest(String name, Date arrivalDate, Date dateOfDeparture, Integer id) throws ParseException {
        guest = listRefresher.refreshGuest(new Guest(name, arrivalDate, dateOfDeparture, id), guest);
    }

    public void importGuests(String path) throws IOException, ParseException {
        List<String> list = transfer.importData(path);  
        for (int i = 1; i < list.size(); i++) {
            guest = listRefresher.refreshGuest(new Guest((String) list.get(i)), guest);
        }
    }

    public void serializeData() {
        serialization.serializeGuest(this.path, this.guest);
    }

    public void deserializeData() {
        Object deserializeData = serialization.deSerialize(this.path);
        if (deserializeData != null) {
            this.guest = (ArrayList<Guest>) deserializeData;
        }
    }

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
