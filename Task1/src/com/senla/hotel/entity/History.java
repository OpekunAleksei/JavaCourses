package com.senla.hotel.entity;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class History {

    private Room room;
    private Guest guest;
    private ArrayList<Service> service;
    private Boolean enable;

    public History() {
        this.enable = true;
        this.guest = null;
        this.room = null;
        this.service = null;
        this.service = new ArrayList<>();
    }

    public Integer getAmontForService() {
        Integer amontForService = 0;
        for (int i = 0; i < this.service.size(); i++) {
            amontForService = amontForService + this.service.get(i).getPrice();
        }
        return amontForService;
    }

    public void setService(Service service) {

        this.service.add(service);
        if (this.service.get(this.service.size() - 1).getPrice() == null) {
            this.service.remove(this.service.size() - 1);
        }
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
        return this.service.size();
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public ArrayList<Service> getService() {
        return service;
    }

    public void setService(ArrayList<Service> service) {
        this.service = service;
    }

}
