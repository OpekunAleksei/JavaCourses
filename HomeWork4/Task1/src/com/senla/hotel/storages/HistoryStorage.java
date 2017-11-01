/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.storages;

import com.senla.hotel.entity.Service;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.History;
import com.senla.hotel.entity.Guest;
import com.senla.hotel.utils.TextWorker;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class HistoryStorage {

    private History history[];
    private Integer counter;

    public HistoryStorage() {
        this.history = new History[100];
        this.counter = 0;
    }

    public void settleInRoom(Guest guest, Room room) throws ParseException {
        this.history[this.counter] = new History();
        this.history[this.counter].setRoom(room);
        this.history[this.counter].setGuest(guest);
        counter++;

    }

    public void addServiceToGuest(Service service, Guest guest) {
        this.history[getItemNumberHistoryOfGuest(guest)].setService(service);
    }

    public void evictedFromRoom(Guest guest) throws ParseException {

        this.history[getItemNumberHistoryOfGuest(guest)].setEnable(Boolean.FALSE);
    }

    public Integer getNumberGuestInHotel() {
        int numberGuestInHotel = 0;
        for (int i = 0; i < counter; i++) {

            if (Objects.equals(this.history[i].getEnable(), Boolean.TRUE)) {
                numberGuestInHotel = numberGuestInHotel + 1;
            }
        }
        return numberGuestInHotel;
    }

    public String getListOfRoomsAvailableByDate(Date date) {
        TextWorker printer = new TextWorker();
        for (int i = 0; i < counter; i++) {

            if (this.history[i].getGuest().getArrivalDate().before(date) == true && this.history[i].getGuest().getDateOfDeparture().after(date) == false) {

                printer.CreateList(this.history[i].getRoom().getNumber());
                printer.addNewLine();

            }

        }
        return printer.getList();
    }

    public String getListLeftGuestThisRoom(Room room) throws ParseException {
        TextWorker printer = new TextWorker();
        if (Objects.equals(this.counter, 3)) {
            for (int i = this.counter - 1; i >= this.counter - 3; i--) {
                if (Objects.equals(this.history[i].getRoom().getId(), room.getId()) && this.history[i].getEnable() == false) {
                    printer.CreateList(this.history[i].getGuest().getName());
                    printer.CreateList(this.history[i].getGuest().getArrivalDate());
                    printer.CreateList(this.history[i].getGuest().getDateOfDeparture());
                    printer.addNewLine();
                }
            }
        }

        return printer.getList();
    }

    public Boolean checkForPresenceGuestsInRoom(Room room) {
        Integer checkCount = 0;
        Integer count = 0;
        Boolean check = false;
        for (int i = 0; i < this.counter; i++) {

            if (Objects.equals(this.history[i].getRoom().getId(), room.getId())) {
                count++;
            }
        }
        for (int i = 0; i < counter; i++) {
            if (Objects.equals(this.history[i].getRoom().getId(), room.getId()) && this.history[i].getEnable() == false) {
                checkCount++;
            }
        }
        if (Objects.equals(checkCount, count)) {

            check = true;
        }
        return check;
    }

    public Integer getGuestPriceForAccommodation(Guest guest) {
        Integer guestAmountForAccommodation = 0;
        Integer days = 0;
        days = (int) (this.history[getItemNumberHistoryOfGuest(guest)].getGuest().getDateOfDeparture().getTime() - this.history[getItemNumberHistoryOfGuest(guest)].getGuest().getArrivalDate().getTime()) / (24 * 60 * 60 * 1000);

        guestAmountForAccommodation = this.history[getItemNumberHistoryOfGuest(guest)].getAmontForService() + this.history[getItemNumberHistoryOfGuest(guest)].getRoom().getPrice() * days;
        return guestAmountForAccommodation;
    }

    private Integer getItemNumberHistoryOfGuest(Guest guest) {
        Integer itemNumber = 0;

        for (int i = 0; i < this.counter; i++) {
            if (this.history[i].getGuest().getId().equals(guest.getId())) {
                itemNumber = i;
            }
        }
        return itemNumber;
    }

    public Service[] getArrayGuestService(Guest guest) {
        return this.history[getItemNumberHistoryOfGuest(guest)].getService();
    }

    public String getListOfGuestService(Guest guest) {
        TextWorker textWorker = new TextWorker();
        textWorker.CreateList(this.history[getItemNumberHistoryOfGuest(guest)].getService(), this.history[getItemNumberHistoryOfGuest(guest)].getCounterForService());
        return textWorker.getList();
    }

}
