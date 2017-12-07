/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.storages;

import com.senla.hotel.api.storages.IHistoryStorage;
import com.senla.hotel.entity.Service;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.History;
import com.senla.hotel.entity.Guest;
import com.senla.hotel.utils.Serialization;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class HistoryStorage implements IHistoryStorage{

    private final Serialization serialization = new Serialization();
    private List<History> history;
    private String path;
    private static HistoryStorage historyStorage;

    private HistoryStorage() {
        this.history = new ArrayList<>();
        this.path = null;

    }

    public static HistoryStorage getInstance() {
        if (historyStorage == null) {
            historyStorage = new HistoryStorage();
        }
        return historyStorage;
    }
@Override
    public void setPath(String path) {
        this.path = path;
    }
@Override
    public void deserializeData() {
        Object deserializeData = serialization.deSerialize(this.path);
        if (deserializeData != null) {
            this.history = (ArrayList<History>) deserializeData;
        }
    }
@Override
    public void serializeData() {
        serialization.serializeHistory(path, history);
    }
@Override
    public void settleInRoom(Guest guest, Room room) {
        this.history.add(new History());
        this.history.get(this.history.size() - 1).setRoom(room);
        this.history.get(this.history.size() - 1).setGuest(guest);

        for (int i = 0; i < this.history.size(); i++) {
            if (Objects.equals(this.history.get(i).getRoom().getId(), this.history.get(this.history.size() - 1).getRoom().getId())) {

                if (this.history.get(this.history.size() - 1).getArrivalDate() == null || this.history.get(this.history.size() - 1).getArrivalDate().after(this.history.get(i).getGuest().getArrivalDate()) == true) {

                    this.history.get(this.history.size() - 1).setArrivalDate(this.history.get(i).getGuest().getArrivalDate());
                    this.history.get(i).setArrivalDate(this.history.get(this.history.size() - 1).getGuest().getArrivalDate());

                }
                if (this.history.get(this.history.size() - 1).getDateOfDeparture() == null || this.history.get(this.history.size() - 1).getDateOfDeparture().before(this.history.get(i).getGuest().getDateOfDeparture())) {
                    this.history.get(this.history.size() - 1).setDateOfDeparture(this.history.get(i).getGuest().getDateOfDeparture());
                    this.history.get(i).setDateOfDeparture(this.history.get(this.history.size() - 1).getGuest().getDateOfDeparture());

                }
            }
        }

    }
@Override
    public void addServiceToGuest(Service service, Guest guest, Room room) {
        this.history.get(getItemNumberHistoryOfGuest(guest, room)).setService(service);
    }
@Override
    public void evictedFromRoom(Guest guest, Room room) {
        this.history.get(getItemNumberHistoryOfGuest(guest, room)).setEnable(Boolean.FALSE);

    }
@Override
    public Integer getNumberGuestInHotel() {
        int numberGuestInHotel = 0;
        for (int i = 0; i < history.size(); i++) {

            if (Objects.equals(this.history.get(i).getEnable(), Boolean.TRUE)) {
                numberGuestInHotel = numberGuestInHotel + 1;
            }
        }
        return numberGuestInHotel;
    }
@Override
    public List<Room> getListOfRoomsAvailableByDate(Date date, List<Room> rList) {

        List<Room> aList = new ArrayList();
        Set hList = new HashSet<>();
        if (history.isEmpty()) {
            for (int i = 0; i < rList.size(); i++) {
                aList.add(rList.get(i));
            }
        } else {
            for (int i = 0; i < history.size(); i++) {

                for (int j = 0; j < rList.size(); j++) {

                    if (Objects.equals(this.history.get(i).getRoom().getId(), rList.get(j).getId())) {

                        if (this.history.get(i).getArrivalDate().before(date) == true && this.history.get(i).getDateOfDeparture().after(date) == false) {

                            aList.add(this.history.get(i).getRoom());
                        }
                    } else {
                        aList.add(rList.get(j));

                    }
                }
            }
        }
        hList.addAll(aList);
        aList.clear();
        aList.addAll(hList);
        return aList;
    }
@Override
    public List<Guest> getListLeftGuestThisRoom(Room room, Integer count) {
        List<Guest> aList = new ArrayList<>();
        if (Objects.equals(this.history.size(), count)) {
            for (int i = this.history.size() - 1; i >= this.history.size() - count; i--) {
                if (Objects.equals(this.history.get(i).getRoom().getId(), room.getId()) && this.history.get(i).getEnable() == false) {
                    aList.add(this.history.get(i).getGuest());
                }
            }
        }     
        return aList;
    }
@Override
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
@Override
    public Integer getGuestPriceForAccommodation(Guest guest, Room room) {

        Integer days = (int) (this.history.get(getItemNumberHistoryOfGuest(guest, room)).getGuest().getDateOfDeparture().getTime() - this.history.get(getItemNumberHistoryOfGuest(guest, room)).getGuest().getArrivalDate().getTime()) / (24 * 60 * 60 * 1000);
        Integer guestAmountForAccommodation = this.history.get(getItemNumberHistoryOfGuest(guest, room)).getAmontForService() + this.history.get(getItemNumberHistoryOfGuest(guest, room)).getRoom().getPrice() * days;

        return guestAmountForAccommodation;
    }

    private Integer getItemNumberHistoryOfGuest(Guest guest, Room room) {

        for (int i = 0; i < this.history.size(); i++) {
            if (this.history.get(i).getGuest().getId().equals(guest.getId()) && this.history.get(i).getEnable() && this.history.get(i).getRoom().getId().equals(room.getId())) {
                return i;
            }

        }
        return null;
    }
@Override
    public List<Service> getGuestServices(Guest guest, Room room) {
        return this.history.get(getItemNumberHistoryOfGuest(guest, room)).getService();
    }
}
