package com.senla.hotel.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class History {

    private Room room;
    private Guest guest;
    private Service service[];
    private Boolean enable;
    private Integer counterForService = 0;

    public History() {
        this.enable = true;
        this.guest = null;
        this.room = null;
        this.service = null;
        this.service = new Service[100];
    }

    public Integer getAmontForService() {
        Integer amontForService = 0;
        for (int i = 0; i < this.counterForService; i++) {
            amontForService = amontForService + this.service[i].getPrice();
        }
        return amontForService;
    }

    public void setService(Service service) {
        this.service[counterForService] = new Service();
        this.service[counterForService] = service;
        counterForService++;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Integer getCounterForService() {
        return counterForService;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Service[] getService() {
        return service;
    }

    public void setService(Service[] service) {
        this.service = service;
    }

}
