/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.entity;

import com.senla.hotel.enums.RoomStatus;

public class Room extends Entity implements Cloneable {

    private Integer number;
    private Integer price;
    private Integer capacity;
    private Integer numberOfStars;
    private Boolean busy;
    private RoomStatus status;
    private Integer id;

    public Room(Integer number, Integer price, Integer capacity, Integer numberOfStars, Integer id, RoomStatus status) {
        this.busy = Boolean.FALSE;
        this.number = number;
        this.capacity = capacity;
        this.id = id;
        this.numberOfStars = numberOfStars;
        this.price = price;
        this.status = status;
    }

    public Room(String line) {
        String[] arr = line.split(";");
        this.busy = Boolean.FALSE;
        this.number = Integer.parseInt(arr[0]);
        this.capacity = Integer.parseInt(arr[1]);
        this.id = Integer.parseInt(arr[2]);
        this.numberOfStars = Integer.parseInt(arr[3]);
        this.price = Integer.parseInt(arr[4]);
        if ("repaired".equals(arr[5])) {
            this.status = RoomStatus.repaired;
        } else {
            this.status = RoomStatus.serviced;
        }
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Room room = (Room) super.clone();
        room.setId(null);
        room.setNumber(null);
        return room;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Boolean getBusy() {
        return busy;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(Integer numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setBusy(Boolean busy) {
        this.busy = busy;
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
