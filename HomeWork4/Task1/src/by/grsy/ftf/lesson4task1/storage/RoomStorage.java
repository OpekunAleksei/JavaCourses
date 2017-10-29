/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grsy.ftf.lesson4task1.storage;

import by.grsy.ftf.lesson4task1.entity.Room;
import by.grsy.ftf.lesson4task1.enumList.RoomStatus;
import java.util.Date;

public class RoomStorage {
    private Integer counterForRoom;
    private Room room[];
    private Room emptyRoom[];
    private Integer counterForEmptyRoom;
    private Integer count = 0;

    public RoomStorage() {
        this.room = new Room[100];
        this.emptyRoom = new Room[100];
        this.counterForRoom = 0;
        this.counterForEmptyRoom = 0;
    }

    public Room getRoom() {
        return this.room[this.counterForRoom - 1];
    }

    public Room[] getArrayRoom() {
        return room;
    }

    public Room[] getEmptyRoomInHotel() {
        for (int i = 0; i < counterForRoom; i++) {
            if (this.room[i].getBusy() == false) {

                this.emptyRoom[counterForEmptyRoom] = new Room(null);
                this.emptyRoom[counterForEmptyRoom] = this.room[i];
                counterForEmptyRoom++;
                count++;
            }
        }
        return this.emptyRoom;
    }

    public void setRoom(Room room) {
        this.room[this.counterForRoom] = new Room(null);
        this.room[this.counterForRoom] = room;
        this.counterForRoom++;
    }

    public String getListOfEmptyRooms() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.counterForEmptyRoom; i++) {
            builder.append(this.emptyRoom[i].getNumber());
            builder.append("\n");
            this.emptyRoom[i] = null;

        }
        String listOfRooms = "";
        listOfRooms = builder.toString();
        this.counterForEmptyRoom = 0;
        return listOfRooms;
    }

    public String getListOfRooms() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.counterForRoom; i++) {
            builder.append(this.room[i].getNumber());
            builder.append("\n");
        }
        String listOfRooms;
        listOfRooms = builder.toString();

        return listOfRooms;
    }
   public RoomStatus setRoo() {
        return room[1].getStatus();
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

    public void changeRoomPrice(Room room, Integer price) {
        this.room[getItemNumberRoom(room)].setPrice(price);
    }

    public String getDetailsOfRoom(Room room) {
        StringBuilder builder = new StringBuilder();
        builder.append("Busy: ");
        builder.append(this.room[getItemNumberRoom(room)].getBusy());
        builder.append(" Capacity: ");
        builder.append(this.room[getItemNumberRoom(room)].getCapacity());
        builder.append(" ID: ");
        builder.append(this.room[getItemNumberRoom(room)].getId());
        builder.append(" Number: ");
        builder.append(this.room[getItemNumberRoom(room)].getNumber());
        builder.append(" NumberOfStars: ");
        builder.append(this.room[getItemNumberRoom(room)].getNumberOfStars());
        builder.append(" Price: ");
        builder.append(this.room[getItemNumberRoom(room)].getPrice());
        builder.append(" Status: ");
        builder.append(this.room[getItemNumberRoom(room)].getStatus());
        builder.append(" ArrivalDate: ");
        builder.append(this.room[getItemNumberRoom(room)].getArrivalDate());
        builder.append(" DateOfDeparture: ");
        builder.append(this.room[getItemNumberRoom(room)].getDateOfDeparture());
        String detailsOfRoom;
        detailsOfRoom = builder.toString();
        return detailsOfRoom;
    }

    public void setDatesOfGuestStay(Boolean busy, Room room, Date arrivalDate, Date dateOfDeparture) {
        this.room[getItemNumberRoom(room)].setArrivalDate(arrivalDate);
        this.room[getItemNumberRoom(room)].setDateOfDeparture(dateOfDeparture);
        this.room[getItemNumberRoom(room)].setBusy(busy);
    }

    public Integer getRoomId(Room room) {
        return this.room[getItemNumberRoom(room)].getNumber();
    }

    public void changeRoomStatus(Room room, RoomStatus status) {
        this.room[getItemNumberRoom(room)].setStatus(status);

    }

}
