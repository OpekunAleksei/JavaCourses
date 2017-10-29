/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grsy.ftf.lesson4task1.entity;

import java.text.ParseException;

public class Table extends Entity {

    private Integer id;
    private Guest guest[];
    private Room room;
    private Service service[];
    private int counterForGuest = 0;
    private int counterForLeftGuest = 0;
    private int counterForService = 0;
    private Guest leftGuest[];

    public void setLeftGuest(Guest leftGuest) throws ParseException {

        this.leftGuest[counterForLeftGuest] = new Guest(null);
        this.leftGuest[counterForLeftGuest] = leftGuest;
        counterForLeftGuest++;
    }

    public void clearServices() {
        for (int i = 0; i < counterForService; i++) {
            this.service[i] = null;
        }
        this.counterForService = 0;
    }

    public Integer getAmontForService() {

        Integer amontForService = 0;
        for (int i = 0; i < this.counterForService; i++) {
            amontForService = amontForService + this.service[i].getPrice();
        }
        return amontForService;
    }

    public Guest[] getLeftGuest() {
        return leftGuest;
    }

    public Table(Integer id, Guest guest, Room room, Service[] service) {
        this.id = id;
        this.guest = new Guest[100];
        this.room = room;
        this.service = new Service[100];
        this.leftGuest = new Guest[100];
    }

    public void setService(Service service) {
        this.service[counterForService] = new Service(null);
        this.service[counterForService] = service;
        counterForService++;
    }

    public void refreshArrayGuest(Guest guest) {
        int counter = 0;
        for (int i = 0; i < this.counterForGuest; i++) {
            if (this.guest[i].getId().equals(guest.getId())) {
                counter = i;
                for (int c = counter; c < this.counterForGuest - 1; c++) {

                    this.guest[c] = this.guest[c + 1];
                }
                this.counterForGuest--;
            }
        }
    }

    public int getCounterGuest() {
        return counterForGuest;
    }

    public Boolean belongsToTableGuest(Guest guest) {
        Boolean bool = false;
        for (int i = 0; i < this.counterForGuest; i++) {
            if (this.guest[i].getId().equals(guest.getId())) {
                bool = true;
            }
        }
        return bool;
    }

    public Boolean emptyRoom() {
        Boolean bool = false;
        if ((this.guest[0] == null) || (this.guest[0].getNuberOfRoom() == null)) {
            bool = true;
        }
        return bool;
    }

    public void setRoom(Room room) {
        this.room = new Room(null);
        this.room = room;
    }

    public String getListLeftGuest() {
        StringBuilder builder = new StringBuilder();
        if (counterForLeftGuest < 3) {
            builder.append("Didnt have 3 guest");
        } else {
            for (int i = counterForLeftGuest - 1; i >= 0; i--) {
                builder.append(this.leftGuest[i].getName());
                builder.append(" ");
                builder.append(this.leftGuest[i].getArrivalDate());
                builder.append(" ");
                builder.append(this.leftGuest[i].getDateOfDeparture());
                builder.append("\n");
            }
        }
        String listLeftGuest;
        listLeftGuest = builder.toString();
        return listLeftGuest;
    }

    public String getListOfServiceGuest() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.room.getNumber());
        builder.append(" ");
        for (int i = 0; i < counterForService; i++) {
            builder.append(this.service[i].getCategory());
            builder.append(" ");
        }
        String listOfServiceGuest;
        listOfServiceGuest = builder.toString();
        return listOfServiceGuest;
    }

    public Guest getGuest() {

        return this.guest[counterForGuest - 1];
    }

    public void setGuest(Guest guest) throws ParseException {
        this.guest[counterForGuest] = new Guest(null);
        this.guest[counterForGuest] = guest;
        counterForGuest++;

    }

    public Service[] getArrayService() {

        return this.service;
    }

    public Service getService() {
        return service[counterForService - 1];
    }

    public Room getRoom() {
        return room;
    }

    public Guest[] getArrayGuest() {
        return guest;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

}
