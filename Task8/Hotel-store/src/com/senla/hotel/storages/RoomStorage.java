/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.storages;

import com.senla.hotel.api.storages.IRoomStorage;
import com.senla.hotel.entity.Room;
import com.senla.hotel.enums.RoomStatus;
import com.senla.hotel.utils.ListRefresher;
import com.senla.hotel.utils.Logger;
import com.senla.hotel.utils.Serialization;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RoomStorage implements IRoomStorage {

    private final Serialization serialization;
    private final ListRefresher listRefresher;
    private List<Room> room;
    private String path;
    private final Logger logger;
    private static RoomStorage roomStorage;

    public RoomStorage() {
        logger = new Logger();
        listRefresher = new ListRefresher();
        serialization = new Serialization();
        this.room = new ArrayList<>();

    }

    public static IRoomStorage getInstance() {
        if (roomStorage == null) {
            roomStorage = new RoomStorage();
        }
        return roomStorage;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void deserializeData() {
        Object deserializeData = serialization.deSerialize(this.path);
        if (deserializeData != null) {
            this.room = (ArrayList<Room>) deserializeData;
        }
    }

    @Override
    public void setImportRooms(List<Room> list) {

        for (int i = 0; i < list.size(); i++) {
            room = listRefresher.refreshRoom(list.get(i), room);
        }
    }

    @Override
    public void serializeData() {
        serialization.serializeRoom(path, room);
    }

    @Override
    public Integer getIdByNumberOnList(Integer number) {
        return room.get(number).getNumber();
    }

    @Override
    public void createRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, Integer id, RoomStatus status) {
        this.room = listRefresher.refreshRoom(new Room(number, price, capacity, numberOfStars, id, status), this.room);
    }

    @Override
    public void changeRoomPrice(Integer numberOfRoom, Integer price) {
        this.room.get(getItemNumberRoom(numberOfRoom)).setPrice(price);
    }

    @Override
    public void changeNumberOfStars(Integer numberOfRoom, Integer numberOfStars) {
        this.room.get(getItemNumberRoom(numberOfRoom)).setNumberOfStars(numberOfStars);
    }

    @Override
    public void changeCapacity(Integer numberOfRoom, Integer capacity) {
        this.room.get(getItemNumberRoom(numberOfRoom)).setCapacity(capacity);
    }

    @Override
    public void copyRoom(Integer numberOfRoom, Integer newId, Integer newNumber) {
        Room copyRoom;
        try {
            copyRoom = (Room) this.room.get(getItemNumberRoom(numberOfRoom)).clone();
            copyRoom.setNumber(newNumber);
            copyRoom.setId(newId);
            copyRoom.setBusy(Boolean.FALSE);
            this.room = listRefresher.refreshRoom(copyRoom, room);
        } catch (CloneNotSupportedException ex) {
            logger.writeErrToFile("Problem in copy", ex);
        }

    }

    @Override
    public void changeRoomStatus(Integer numberOfRoom, RoomStatus status) {
        this.room.get(getItemNumberRoom(numberOfRoom)).setStatus(status);

    }

    @Override
    public void changeRoomBusy(Integer numberOfRoom, Boolean busy) {

        this.room.get(getItemNumberRoom(numberOfRoom)).setBusy(busy);

    }

    @Override
    public List<Room> getDetailsOfRoom(Integer numberOfRoom) {
        List<Room> aList = new ArrayList();
        aList.add(this.room.get(getItemNumberRoom(numberOfRoom)));
        return aList;
    }

    @Override
    public Room getRoom(Integer numberOfRoom) {

        return this.room.get(getItemNumberRoom(numberOfRoom));
    }

    @Override
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

    @Override
    public List<Room> getRooms() {
        return room;
    }

}
