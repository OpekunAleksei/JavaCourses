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
import com.senla.hotel.utils.Logger;
import com.senla.hotel.utils.TextWorker;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class HistoryStorage {

    private ArrayList<History> history;

    private Logger logger;

    public HistoryStorage() {
        this.history = new ArrayList<>();

        this.logger = new Logger();
    }

    public void settleInRoom(Guest guest, Room room) throws ParseException {
        this.history.add(new History());
        this.history.get(this.history.size() - 1).setRoom(room);
        this.history.get(this.history.size() - 1).setGuest(guest);

    }

    public void addServiceToGuest(Service service, Guest guest) {
        this.history.get(getItemNumberHistoryOfGuest(guest)).setService(service);
    }

    public void evictedFromRoom(Guest guest) throws ParseException {
        this.history.get(getItemNumberHistoryOfGuest(guest)).setEnable(Boolean.FALSE);

    }

    public Integer getNumberGuestInHotel() {
        int numberGuestInHotel = 0;
        for (int i = 0; i < history.size(); i++) {

            if (Objects.equals(this.history.get(i).getEnable(), Boolean.TRUE)) {
                numberGuestInHotel = numberGuestInHotel + 1;
            }
        }
        return numberGuestInHotel;
    }

    public String getListOfRoomsAvailableByDate(Date date) {
        TextWorker printer = new TextWorker();
        for (int i = 0; i < history.size(); i++) {

            if (this.history.get(i).getGuest().getArrivalDate().before(date) == true && this.history.get(i).getGuest().getDateOfDeparture().after(date) == false) {

                printer.CreateList(this.history.get(i).getRoom().getNumber());
                printer.addNewLine();

            }

        }
        return printer.getList();
    }

    public String getListLeftGuestThisRoom(Room room) throws ParseException {
        TextWorker printer = new TextWorker();
        if (Objects.equals(this.history.size(), 3)) {
            for (int i = this.history.size() - 1; i >= this.history.size() - 3; i--) {
                if (Objects.equals(this.history.get(i).getRoom().getId(), room.getId()) && this.history.get(i).getEnable() == false) {
                    printer.CreateList(this.history.get(i).getGuest().getName());
                    printer.CreateList(this.history.get(i).getGuest().getArrivalDate());
                    printer.CreateList(this.history.get(i).getGuest().getDateOfDeparture());
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
        for (int i = 0; i < this.history.size(); i++) {

            if (Objects.equals(this.history.get(i).getRoom().getId(), room.getId())) {
                count++;
            }
        }
        for (int i = 0; i < history.size(); i++) {
            if (Objects.equals(this.history.get(i).getRoom().getId(), room.getId()) && this.history.get(i).getEnable() == false) {
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
        days = (int) (this.history.get(getItemNumberHistoryOfGuest(guest)).getGuest().getDateOfDeparture().getTime() - this.history.get(getItemNumberHistoryOfGuest(guest)).getGuest().getArrivalDate().getTime()) / (24 * 60 * 60 * 1000);

        guestAmountForAccommodation = this.history.get(getItemNumberHistoryOfGuest(guest)).getAmontForService() + this.history.get(getItemNumberHistoryOfGuest(guest)).getRoom().getPrice() * days;

        return guestAmountForAccommodation;
    }

    private Integer getItemNumberHistoryOfGuest(Guest guest) {
        Integer itemNumber = 0;
        Integer test = null;
        for (int i = 0; i < this.history.size(); i++) {
            if (this.history.get(i).getGuest().getId().equals(guest.getId())) {
                itemNumber = i;
                test = i;
            }

        }
        if (test != null) {
            return itemNumber;
        } else {
            return test;
        }
    }

    public ArrayList<Service> getArrayGuestService(Guest guest) {
        return this.history.get(getItemNumberHistoryOfGuest(guest)).getService();
    }

    public String getListOfGuestService(Guest guest) {
        TextWorker textWorker = new TextWorker();
        textWorker.CreateList(this.history.get(getItemNumberHistoryOfGuest(guest)).getService());
        return textWorker.getList();
    }

}
