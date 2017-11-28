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

    private final ListRefresher listRefresher;
    private List<Guest> guest;
    private final String path;
    private final Serialization serialization;
    private final Transfer transfer;

    public GuestStorage(String path) {
        transfer = new Transfer();
        serialization = new Serialization();
        listRefresher = new ListRefresher();
        this.guest = new ArrayList<>();
        this.path = path;

    }

    public List<Guest> getGuests() {
        return guest;
    }

    public void exportGuests(String path) throws IOException {
        transfer.exportGuestData(path, getLisOfGuest());
    }

    public Integer getIdByNumberOnList(Integer number) {
        return guest.get(number).getId();
    }

    public void createGuest(String name, Date arrivalDate, Date dateOfDeparture, Integer id) throws ParseException {
        guest = listRefresher.refreshGuest(new Guest(name, arrivalDate, dateOfDeparture, id), guest);
    }

    public void importGuests(String path) throws IOException, ParseException {
        for (int i = 1; i < transfer.importData(path).size(); i++) {
            guest = listRefresher.refreshGuest(new Guest((String) transfer.importData(path).get(i)), guest);
        }
    }

    public void serializeData() {
        serialization.serializeGuest(path, this.guest);
    }

    public void deserializeData() {
        if (serialization.deSerialize(path) != null) {
            this.guest = (ArrayList<Guest>) serialization.deSerialize(path);
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

    public String getLisOfGuest() {
        TextWorker textWorker = new TextWorker();
        textWorker.CreateGuestList(guest);
        return textWorker.getList();
    }

}
