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
import java.util.ArrayList;
import java.util.Objects;

public class RoomStorage {

    private ArrayList<Room> room;
    private String path;
    private FileWorker fileWorker;
    private static Integer counter = 0;

    public RoomStorage(String path) {

        this.room = new ArrayList<>();

        if (path == null) {
            path = "D:\\roomFile.txt";
        }
        this.path = path;
        this.fileWorker = new FileWorker();
    }

    public void writeToRoomFile(String[] array) {

        fileWorker.writeToRoomFile(this.path, array);
    }

    public void createRoom() {
        this.fileWorker.readFromFile(path);
        if (fileWorker.readFromFile(path)[counter].equalsIgnoreCase("null") == false) {
            this.room.add(new Room(fileWorker.readFromFile(path)[counter]));
            counter++;
        }

    }

    public void changeRoomPrice(Integer numberOfRoom, Integer price) {
        this.room.get(getItemNumberRoomByNumber(numberOfRoom)).setPrice(price);
    }

    public void changeRoomStatus(Integer numberOfRoom, RoomStatus status) {
        this.room.get(getItemNumberRoomByNumber(numberOfRoom)).setStatus(status);

    }

    public void changeRoomBusy(Integer numberOfRoom, Boolean busy) {

        this.room.get(getItemNumberRoomByNumber(numberOfRoom)).setBusy(busy);

    }

    public String getDetailsOfRoom(Integer numberOfRoom) {
        TextWorker printer = new TextWorker();
        printer.CreateList(this.room.get(getItemNumberRoomByNumber(numberOfRoom)).getBusy());
        printer.CreateList(this.room.get(getItemNumberRoomByNumber(numberOfRoom)).getCapacity());
        printer.CreateList(this.room.get(getItemNumberRoomByNumber(numberOfRoom)).getNumber());
        printer.CreateList(this.room.get(getItemNumberRoomByNumber(numberOfRoom)).getNumberOfStars());
        printer.CreateList(this.room.get(getItemNumberRoomByNumber(numberOfRoom)).getPrice());
        printer.CreateList(this.room.get(getItemNumberRoomByNumber(numberOfRoom)).getStatus());

        return printer.getList();
    }

    public Room getRoom(Integer numberOfRoom) {

        return this.room.get(getItemNumberRoomByNumber(numberOfRoom));
    }

    public Integer getNumberEmptyRoomInHotel() {

        int numberEmptyRoomInHotel = 0;

        for (int i = 0; i < this.room.size(); i++) {

            if (Objects.equals(this.room.get(i).getBusy(), Boolean.FALSE)) {
                numberEmptyRoomInHotel = numberEmptyRoomInHotel + 1;
            }
        }
        return numberEmptyRoomInHotel;

    }

    private Integer getItemNumberRoomByNumber(Integer numberOfRoom) {
        Integer itemNumber = 0;
        Integer test = null;

        for (int i = 0; i < this.room.size(); i++) {
            if (this.room.get(i).getNumber().equals(numberOfRoom)) {
                itemNumber = i;
                test = i;
            }
        }
        if (test != null) {
            return itemNumber;
        } else {
            return test;
        }
    }

    public Room getRoom() {
        return this.room.get(this.room.size() - 1);
    }

    public String getLisOfEmptyRooms() {

        TextWorker textWorker = new TextWorker();
        textWorker.CreateRoomList(room, getNumberEmptyRoomInHotel());
        return textWorker.getList();
    }

    public String getLisOfRooms() {

        TextWorker textWorker = new TextWorker();
        textWorker.CreateRoomList(this.room, this.room.size());

        return textWorker.getList();
    }

    public ArrayList<Room> getArrayRoom() {
        return room;
    }

    private Integer getItemNumberRoom(Room room) {
        Integer itemNumber = 0;
        Integer test = null;
        for (int i = 0; i < this.room.size(); i++) {
            if (this.room.get(i).getId().equals(room.getId())) {
                itemNumber = i;
                test = i;
            }

        }
        if (test != null) {
            return itemNumber;
        } else {
            return test;
        }
    }
}
