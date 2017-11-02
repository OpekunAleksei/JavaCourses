/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.storages;

import com.senla.hotel.entity.Guest;
import com.senla.hotel.utils.FileWorker;
import com.senla.hotel.utils.TextWorker;
import java.text.ParseException;

public class GuestStorage {

    private Integer counter;
    private Guest guest[];
    private String path;
    private FileWorker fileWorker;

    public GuestStorage(String path) {
        this.guest = new Guest[100];
        this.counter = 0;
        if (path == null) {
            path = "D:\\guestFile.txt";
        }
        this.path = path;

    }

    public Guest[] getArrayGuest() {
        return guest;
    }

    public void createGuest() throws ParseException {
        this.guest[this.counter] = new Guest(path);
        this.counter++;
    }

    public void writeToGuestFile(String[] array) {
        this.fileWorker = new FileWorker();
        fileWorker.writeToGuestFile(this.path, array);
    }

    public Guest getGuest(Integer id) {
        return this.guest[getNumberOfGuestById(id)];
    }

    private Integer getNumberOfGuestById(Integer id) {
        int guestNumber = 0;
        for (int i = 0; i < this.counter; i++) {
            if (this.guest[i].getId().equals(id)) {
                guestNumber = i;
            }
        }
        return guestNumber;
    }

    private Integer getLisOfGuest(Guest guest) {
        int guestNumber = 0;
        for (int i = 0; i < this.counter; i++) {
            if (this.guest[i].getId().equals(guest.getId())) {
                guestNumber = i;
            }
        }
        return guestNumber;
    }

    public String getLisOfGuest() {
        TextWorker textWorker = new TextWorker();
        textWorker.CreateList(guest, counter);
        return textWorker.getList();
    }

}
