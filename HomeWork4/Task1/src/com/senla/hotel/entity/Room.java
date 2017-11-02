/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.entity;

import com.senla.hotel.entity.Entity;
import com.senla.hotel.utils.FileWorker;
import com.senla.hotel.enums.RoomStatus;

public class Room extends Entity {

    private Integer number;
    private Integer price;
    private Integer capacity;
    private Integer numberOfStars;
    private Boolean busy;
    private RoomStatus status;
    private Integer id;
    private static Integer counter = 0;
    private FileWorker fileWorker;
    private String listOfGRoomFromTextFile[] = new String[10];

    public Room(String path) {
        this.fileWorker = new FileWorker();
        if (fileWorker.readFromFile(path)[counter] != null) {
            this.listOfGRoomFromTextFile = fileWorker.readFromFile(path)[counter].split(";");
            this.busy = Boolean.FALSE;
            this.number = Integer.parseInt(this.listOfGRoomFromTextFile[0]);
            this.capacity = Integer.parseInt(this.listOfGRoomFromTextFile[1]);
            this.id = Integer.parseInt(this.listOfGRoomFromTextFile[2]);
            this.numberOfStars = Integer.parseInt(this.listOfGRoomFromTextFile[3]);
            this.price = Integer.parseInt(this.listOfGRoomFromTextFile[4]);
            if ("repaired".equals(this.listOfGRoomFromTextFile[5])) {
                this.status = RoomStatus.repaired;
            } else {
                this.status = RoomStatus.serviced;
            }
            Room.counter++;

        }

    }

    public Integer getNumber() {
        return number;
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
    public void setId(int id) {
        this.id = id;
    }

}
