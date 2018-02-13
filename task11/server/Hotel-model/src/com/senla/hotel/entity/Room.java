/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.entity;

import com.senla.hotel.annotation.enums.PropertyType;
import com.senla.hotel.annotations.CsvEntity;
import com.senla.hotel.annotations.CsvProperty;
import com.senla.hotel.enums.RoomStatus;

@CsvEntity(fileName = "Room.csv", valuesSeparator = ";")
public class Room extends Entity implements Cloneable {

    @CsvProperty(colomnNumber = 0, propertyType = PropertyType.SimpleProperty)
    private Integer number;
    @CsvProperty(colomnNumber = 4, propertyType = PropertyType.SimpleProperty)
    private Integer price;
    @CsvProperty(colomnNumber = 1, propertyType = PropertyType.SimpleProperty)
    private Integer capacity;
    @CsvProperty(colomnNumber = 3, propertyType = PropertyType.SimpleProperty)
    private Integer numberOfStars;
    private Boolean busy;
    @CsvProperty(colomnNumber = 5, propertyType = PropertyType.SimpleProperty)
    private RoomStatus status;
    @CsvProperty(colomnNumber = 2, propertyType = PropertyType.SimpleProperty)
    private Integer id;

    public Room(Integer number, Integer price, Integer capacity, Integer numberOfStars, Integer id, RoomStatus status,Boolean busy) {
        this.busy = busy;
        this.number = number;
        this.capacity = capacity;
        this.id = id;
        this.numberOfStars = numberOfStars;
        this.price = price;
        this.status = status;
    }

    public Room() {
        this.busy = Boolean.FALSE;
        this.number = null;
        this.capacity = null;
        this.id = null;
        this.numberOfStars = null;
        this.price = null;
        this.status = null;
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
