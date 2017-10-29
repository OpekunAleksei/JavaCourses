/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grsy.ftf.lesson4task1.manager;

import by.grsy.ftf.lesson4task1.entity.Guest;
import by.grsy.ftf.lesson4task1.comparator.GuestComparator;
import by.grsy.ftf.lesson4task1.storage.GuestStorage;
import java.text.ParseException;
import java.util.Arrays;

public class GuestManager {

    private GuestStorage guestStorage;

    public GuestManager() {
        guestStorage = new GuestStorage();
    }

    public void createGuest(Guest guest) throws ParseException {
        guestStorage.setGuest(guest);
    }

    public void setRoomNumber(Guest guest, Integer roomNumber) {
        guestStorage.setRoomNumber(guest, roomNumber);
    }

    public String getSortGuestByName() {
        Arrays.sort(guestStorage.getGuest(), new GuestComparator().getNameComparator());
        return guestStorage.getListOfGuest();
    }

    public String getSortGuestByDateOfDeparture() {
        Arrays.sort(guestStorage.getGuest(), new GuestComparator().getDateComparator());
        return guestStorage.getListOfGuest();
    }

    public Guest getGuest(Guest guest) {
        return guestStorage.getGuest(guest);
    }
}
