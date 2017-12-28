/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.storages;

import com.senla.hotel.entity.Room;
import com.senla.hotel.enums.RoomStatus;
import java.util.List;

public interface IRoomStorage {

    public void setPath(String path);

    public void deserializeData();

    public void setImportRooms(List<Room> list);

    public void serializeData();

    public Integer getIdByNumberOnList(Integer number);

    public void createRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, Integer id, RoomStatus status);

    public void changeRoomPrice(Integer numberOfRoom, Integer price);

    public void changeNumberOfStars(Integer numberOfRoom, Integer numberOfStars);

    public void changeCapacity(Integer numberOfRoom, Integer capacity);

    public void copyRoom(Integer numberOfRoom, Integer newId, Integer newNumber);

    public void changeRoomStatus(Integer numberOfRoom, RoomStatus status);

    public void changeRoomBusy(Integer numberOfRoom, Boolean busy);

    public List<Room> getDetailsOfRoom(Integer numberOfRoom);

    public Room getRoom(Integer numberOfRoom);

    public Integer getNumberEmptyRoom();

    public List<Room> getRooms();

}
