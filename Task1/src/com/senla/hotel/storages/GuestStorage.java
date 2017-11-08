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
import java.util.ArrayList;

public class GuestStorage {

    private ArrayList<Guest> guest;
    private String path;
    private FileWorker fileWorker;
    private static Integer counter = 0;

    public GuestStorage(String path) {
        this.guest = new ArrayList<>();
        if (path == null) {
            path = "D:\\guestFile.txt";
        }
        this.path = path;
        this.fileWorker = new FileWorker();
    }

    public ArrayList<Guest> getArrayGuest() {
        return guest;
    }

    public void createGuest() throws ParseException {
        this.fileWorker.readFromFile(path);
        if (fileWorker.readFromFile(path)[counter].equalsIgnoreCase("null") == false) {
            this.guest.add(new Guest(fileWorker.readFromFile(path)[counter]));
            counter++;
        }
    }

    public void writeToGuestFile(String[] array) {
        fileWorker.writeToGuestFile(this.path, array);
    }

    public Guest getGuest(Integer id) {
        return this.guest.get(getNumberOfGuestById(id));
    }

    private Integer getNumberOfGuestById(Integer id) {
        Integer guestNumber = 0;
        Integer test = null;
        for (int i = 0; i < this.guest.size(); i++) {
            if (this.guest.get(i).getId().equals(id)) {
                guestNumber = i;
                test = i;
            }

        }
        if (test != null) {
            return guestNumber;
        } else {
            return test;
        }
    }

    public String getLisOfGuest() {
        TextWorker textWorker = new TextWorker();
        textWorker.CreateGuestList(guest);
        return textWorker.getList();
    }

}
