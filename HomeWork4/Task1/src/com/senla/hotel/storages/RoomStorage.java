/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.storages;

import com.senla.hotel.entity.Room;
import com.senla.hotel.enums.RoomStatus;
import com.senla.hotel.utils.FileWorker;
import com.senla.hotel.utils.TextWorker;
import java.util.Objects;

public class RoomStorage {

    private Integer counterForRoom;
    private Room room[];
    private Integer count = 0;
    private String path;
    private FileWorker fileWorker;

    public RoomStorage(String path) {

        this.room = new Room[100];
        this.counterForRoom = 0;
        if (path == null) {
            path = "D:\\roomFile.txt";
        }
        this.path = path;
    }

    public void writeToRoomFile(String[] array) {
        this.fileWorker = new FileWorker();
        fileWorker.writeToRoomFile(this.path, array);
    }

    public void createRoom() {
        this.room[this.counterForRoom] = new Room(this.path);
        this.counterForRoom++;
    }

    public void changeRoomPrice(Integer numberOfRoom, Integer price) {
        this.room[getItemNumberRoomByNumber(numberOfRoom)].setPrice(price);
    }

    public void changeRoomStatus(Integer numberOfRoom, RoomStatus status) {
        this.room[getItemNumberRoomByNumber(numberOfRoom)].setStatus(status);

    }

    public void changeRoomBusy(Integer numberOfRoom, Boolean busy) {

        this.room[getItemNumberRoomByNumber(numberOfRoom)].setBusy(busy);

    }

    public String getDetailsOfRoom(Integer numberOfRoom) {
        TextWorker printer = new TextWorker();
        printer.CreateList(this.room[getItemNumberRoomByNumber(numberOfRoom)].getBusy());
        printer.CreateList(this.room[getItemNumberRoomByNumber(numberOfRoom)].getCapacity());
        printer.CreateList(this.room[getItemNumberRoomByNumber(numberOfRoom)].getNumber());
        printer.CreateList(this.room[getItemNumberRoomByNumber(numberOfRoom)].getNumberOfStars());
        printer.CreateList(this.room[getItemNumberRoomByNumber(numberOfRoom)].getPrice());
        printer.CreateList(this.room[getItemNumberRoomByNumber(numberOfRoom)].getStatus());

        return printer.getList();
    }

    public Room getRoom(Integer numberOfRoom) {
        return this.room[getItemNumberRoomByNumber(numberOfRoom)];
    }

    public Integer getNumberEmptyRoomInHotel() {

        int numberEmptyRoomInHotel = 0;
        for (int i = 0; i < counterForRoom; i++) {

            if (Objects.equals(this.room[i].getBusy(), Boolean.FALSE)) {
                numberEmptyRoomInHotel = numberEmptyRoomInHotel + 1;
            }
        }
        return numberEmptyRoomInHotel;

    }

    private Integer getItemNumberRoomByNumber(Integer numberOfRoom) {
        int itemNumber = 0;
        for (int i = 0; i < this.counterForRoom; i++) {
            if (this.room[i].getNumber().equals(numberOfRoom)) {
                itemNumber = i;
            }

        }
        return itemNumber;
    }

    public Room getRoom() {
        return this.room[this.counterForRoom - 1];
    }

    public String getLisOfEmptyRooms() {

        TextWorker textWorker = new TextWorker();
        textWorker.CreateList(room, getNumberEmptyRoomInHotel());
        return textWorker.getList();
    }

    public String getLisOfRooms() {

        TextWorker textWorker = new TextWorker();
        textWorker.CreateList(this.room, this.counterForRoom);

        return textWorker.getList();
    }

    public Room[] getArrayRoom() {
        return room;
    }

    public void a() {
        System.err.println(room[0].getBusy());
    }

    private Integer getItemNumberRoom(Room room) {
        int itemNumber = 0;
        for (int i = 0; i < this.counterForRoom; i++) {
            if (this.room[i].getId().equals(room.getId())) {
                itemNumber = i;
            }

        }
        return itemNumber;
    }

}
