package com.senla.hotel.entity;

import java.util.ArrayList;
import java.util.Date;

public class History extends Entity {

    private Integer id;
    private Room room;
    private Guest guest;
    private ArrayList<Service> service;
    private Boolean enable;
    private Date arrivalDate;
    private Date dateOfDeparture;

    public History() {

        this.enable = true;
        this.guest = null;
        this.room = null;
        this.service = null;
        this.service = new ArrayList<>();
        this.arrivalDate = null;
        this.dateOfDeparture = null;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setDateOfDeparture(Date dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    public Date getArrivalDate() {
        return arrivalDate;
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

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

}
