/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grsy.ftf.lesson4task1.storage;

import by.grsy.ftf.lesson4task1.entity.Guest;
import java.text.ParseException;

public class GuestStorage {

    private Integer counter;
    private Guest guest[];
    public GuestStorage() {
        this.guest = new Guest[10];
        this.counter = 0;
    }
    public Guest[] getGuest() {
        return guest;
    }
    public void setGuest(Guest guest) throws ParseException {
        this.guest[this.counter] = new Guest(null);
        this.guest[this.counter] = guest;
        this.counter++;
    }

    public String getListOfGuest() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.counter; i++) {
            builder.append(this.guest[i].getName());
            builder.append(" ");
            builder.append(this.guest[i].getSurName());
            builder.append(" ");
            builder.append(this.guest[i].getNuberOfRoom());
            builder.append("\n");
        }
        String listOfGuest;
        listOfGuest = builder.toString();

        return listOfGuest;

    }

    public Integer getNumberOfGuest(Guest guest) {
        int guestNumber = 0;
        for (int i = 0; i < this.counter; i++) {
            if (this.guest[i].getId().equals(guest.getId())) {
                guestNumber = i;
            }
        }
        return guestNumber;
    }

    public Guest getGuest(Guest guest) {
        return this.guest[getNumberOfGuest(guest)];
    }

    public void setRoomNumber(Guest guest, Integer roomNumber) {
        this.guest[getNumberOfGuest(guest)].setNuberOfRoom(roomNumber);
    }

}
