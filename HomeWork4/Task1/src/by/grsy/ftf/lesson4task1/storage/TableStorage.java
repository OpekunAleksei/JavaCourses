/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grsy.ftf.lesson4task1.storage;

import by.grsy.ftf.lesson4task1.entity.Room;
import by.grsy.ftf.lesson4task1.entity.Guest;
import by.grsy.ftf.lesson4task1.entity.Service;
import by.grsy.ftf.lesson4task1.entity.Table;
import java.text.ParseException;
import java.util.Date;

public class TableStorage {
    private Table table[];
    private Integer counter;

    public TableStorage() {
        this.table = new Table[100];
        this.counter = 0;
    }

    private Integer getItemNumberOfTableRoom(Room room) {
        int itemNumber = 0;
        for (int i = 0; i < this.counter; i++) {
            if (this.table[i].getRoom().getId().equals(room.getId())) {
                itemNumber = i;
            }
        }
        return itemNumber;
    }

    public void addServiceToGuest(Service service, Guest guest) {
        this.table[getItemNumberOfTableGuest(guest)].setService(service);
    }

    private Integer getItemNumberOfTableGuest(Guest guest) {
        int itemNumber = 0;
        for (int i = 0; i < this.counter; i++) {
            if (this.table[i].belongsToTableGuest(guest).equals(true)) {
                itemNumber = i;
            }
        }
        return itemNumber;
    }

    public void setGuestInTable(Guest guest, Room room) throws ParseException {
        this.table[getItemNumberOfTableRoom(room)].setGuest(guest);//////PEREIMENOVAT'
    }

    public Service[] getArrayGuestService(Guest guest) {
        return this.table[getItemNumberOfTableGuest(guest)].getArrayService();
    }

    public String getGuestListOfService(Guest guest) {
        return this.table[getItemNumberOfTableGuest(guest)].getListOfServiceGuest();
    }

    public Integer getNumberEmptyRoomInHotel() {
        int summ = 0;
        for (int i = 0; i < counter; i++) {
            if (this.table[i].emptyRoom() == true) {
                summ++;
            }
        }
        return summ;
    }

    public void setRoomInTable(Room room) {
        table[counter] = new Table(null, null, null, null);
        this.table[counter].setRoom(room);
        counter++;
    }

    public void evictedFromRoom(Guest guest) throws ParseException {
        this.table[getItemNumberOfTableGuest(guest)].clearServices();
        this.table[getItemNumberOfTableGuest(guest)].setLeftGuest(guest);
        this.table[getItemNumberOfTableGuest(guest)].refreshArrayGuest(guest);

    }

    public Integer getNumberGuestInHotel() {
        int summ = 0;
        for (int i = 0; i < counter; i++) {
            summ = summ + this.table[i].getCounterGuest();
        }
        return summ;
    }

    public Room getRoomInTable(Guest guest) {
        return table[getItemNumberOfTableGuest(guest)].getRoom();
    }

    public String getListLeftGuestThisRoom(Room room) {
        return table[getItemNumberOfTableRoom(room)].getListLeftGuest();
    }


    public String getListOfRoomsAvailableByDate(Date date) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < counter; i++) {
            if (this.table[i].getRoom().getArrivalDate() == null && this.table[i].getRoom().getDateOfDeparture() == null) {
                builder.append(this.table[i].getRoom().getNumber());
                builder.append("\n");
            } else if (((this.table[i].getRoom().getArrivalDate().before(date)) == true && (this.table[i].getRoom().getDateOfDeparture().after(date)) == true)) {
                builder.append(this.table[i].getRoom().getNumber());
                builder.append("\n");
            }
        }
        String listOfRoomsAvailableByDate;
        listOfRoomsAvailableByDate = builder.toString();
        return listOfRoomsAvailableByDate;
    }

    public Integer getGuestPriceForAccommodation(Room room) {
        Integer guestAmountForAccommodation = 0;
        Integer days = 0;
        if (this.table[getItemNumberOfTableRoom(room)].getRoom().getDateOfDeparture() == null) {
            days = 0;
        } else {
            days = (int) (this.table[getItemNumberOfTableRoom(room)].getRoom().getDateOfDeparture().getTime() - this.table[getItemNumberOfTableRoom(room)].getRoom().getArrivalDate().getTime()) / (24 * 60 * 60 * 1000);
        }
        guestAmountForAccommodation = this.table[getItemNumberOfTableRoom(room)].getAmontForService() + this.table[getItemNumberOfTableRoom(room)].getRoom().getPrice() * days;
        return guestAmountForAccommodation;
    }
}
