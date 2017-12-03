/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.storages;

import com.senla.hotel.entity.Room;
import com.senla.hotel.enums.RoomStatus;
import com.senla.hotel.utils.ListRefresher;
import com.senla.hotel.utils.Serialization;
import com.senla.hotel.utils.TextWorker;
import com.senla.hotel.utils.Transfer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RoomStorage {

    private final Serialization serialization;
    private final ListRefresher listRefresher;
    private List<Room> room;
    private String path;
    private final Transfer transfer;
    private static RoomStorage roomStorage;
    private final TextWorker textWorker;

    public RoomStorage() {
        textWorker = new TextWorker();
        listRefresher = new ListRefresher();
        serialization = new Serialization();
        this.room = new ArrayList<>();
        this.transfer = new Transfer();
    }

    public static RoomStorage getInstance() {
        if (roomStorage == null) {
            roomStorage = new RoomStorage();
        }
        return roomStorage;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void deserializeData() {
        Object deserializeData = serialization.deSerialize(this.path);
        if (deserializeData != null) {
            this.room = (ArrayList<Room>) deserializeData;
        }
    }

    public void importRooms(String path) throws IOException {
        List<String> list = transfer.importData(path);               
        for (int i = 1; i <list.size(); i++) {
            room = listRefresher.refreshRoom(new Room((String) list.get(i)), room);
        }
    }

    public void exportRooms(String path) throws IOException {
        transfer.exportRoomData(path, textWorker.CreateRoomList(room,null));
    }

    public void serializeData() {
        serialization.serializeRoom(path, room);
    }

    public Integer getIdByNumberOnList(Integer number) {
        return room.get(number).getNumber();
    }

    public void createRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, Integer id, RoomStatus status) {
        this.room = listRefresher.refreshRoom(new Room(number, price, capacity, numberOfStars, id, status), this.room);
    }

    public void changeRoomPrice(Integer numberOfRoom, Integer price) {
        this.room.get(getItemNumberRoom(numberOfRoom)).setPrice(price);
    }

    public void changeNumberOfStars(Integer numberOfRoom, Integer numberOfStars) {
        this.room.get(getItemNumberRoom(numberOfRoom)).setNumberOfStars(numberOfStars);
    }

    public void changeCapacity(Integer numberOfRoom, Integer capacity) {
        this.room.get(getItemNumberRoom(numberOfRoom)).setCapacity(capacity);
    }

    public void copyRoom(Integer numberOfRoom, Integer newId, Integer newNumber) throws CloneNotSupportedException {
        Room copyRoom = (Room) this.room.get(getItemNumberRoom(numberOfRoom)).clone();
        copyRoom.setNumber(newNumber);
        copyRoom.setId(newId);
        copyRoom.setBusy(Boolean.FALSE);
        this.room = listRefresher.refreshRoom(copyRoom, room);

    }

    public void changeRoomStatus(Integer numberOfRoom, RoomStatus status) {
        this.room.get(getItemNumberRoom(numberOfRoom)).setStatus(status);

    }

    public void changeRoomBusy(Integer numberOfRoom, Boolean busy) {

        this.room.get(getItemNumberRoom(numberOfRoom)).setBusy(busy);

    }

    public List<Room> getDetailsOfRoom(Integer numberOfRoom) {
        List<Room> aList = new ArrayList();
        aList.add(this.room.get(getItemNumberRoom(numberOfRoom)));
        return aList;
    }

    public Room getRoom(Integer numberOfRoom) {

        return this.room.get(getItemNumberRoom(numberOfRoom));
    }

    public Integer getNumberEmptyRoom() {

        int numberEmptyRoomInHotel = 0;

        for (int i = 0; i < this.room.size(); i++) {

            if (Objects.equals(this.room.get(i).getBusy(), Boolean.FALSE)) {
                numberEmptyRoomInHotel = numberEmptyRoomInHotel + 1;
            }
        }
        return numberEmptyRoomInHotel;

    }

    private Integer getItemNumberRoom(Integer numberOfRoom) {

        for (int i = 0; i < this.room.size(); i++) {
            if (this.room.get(i).getNumber().equals(numberOfRoom)) {
                return i;
            }
        }
        return null;
    }

    public List<Room> getRooms() {
        return room;
    }

}
