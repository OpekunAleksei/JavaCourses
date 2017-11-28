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
import com.senla.hotel.utils.Serialization;
import com.senla.hotel.utils.TextWorker;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class HistoryStorage {

    private final Serialization serialization = new Serialization();
    private List<History> history;
    private final String path;

    public HistoryStorage(String path) {
        this.history = new ArrayList<>();
        this.path = path;

    }

    public void deserializeData() {
        if (serialization.deSerialize(path) != null) {
            this.history = (ArrayList<History>) serialization.deSerialize(path);
        }
    }

    public void serializeData() {
        serialization.serializeHistory(path, history);
    }

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

    public void addServiceToGuest(Service service, Guest guest, Room room) {
        this.history.get(getItemNumberHistoryOfGuest(guest, room)).setService(service);
    }

    public void evictedFromRoom(Guest guest, Room room) {

        this.history.get(getItemNumberHistoryOfGuest(guest, room)).setEnable(Boolean.FALSE);

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

    public String getListOfRoomsAvailableByDate(Date date, List<Room> rList) {
        TextWorker textWorker = new TextWorker();
        List aList = new ArrayList();
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
        textWorker.CreateRoomList(aList, aList.size());
        return textWorker.getList();
    }

    public String getListLeftGuestThisRoom(Room room, Integer count) {
        TextWorker textWorker = new TextWorker();
        List AList = new ArrayList<>();
        if (Objects.equals(this.history.size(), count)) {
            for (int i = this.history.size() - 1; i >= this.history.size() - count; i--) {
                if (Objects.equals(this.history.get(i).getRoom().getId(), room.getId()) && this.history.get(i).getEnable() == false) {
                    AList.add(this.history.get(i).getGuest());
                }
            }
        }
        textWorker.CreateGuestList(AList);
        return textWorker.getList();
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

    public List<Service> getGuestServices(Guest guest, Room room) {
        return this.history.get(getItemNumberHistoryOfGuest(guest, room)).getService();
    }

    public String getListOfGuestService(Guest guest, Room room) {
        TextWorker textWorker = new TextWorker();
        textWorker.CreateServiceList(this.history.get(getItemNumberHistoryOfGuest(guest, room)).getService());
        return textWorker.getList();
    }

}
