/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.managers;

import com.senla.hotel.entity.Room;
import com.senla.hotel.enums.RoomStatus;
import java.util.Comparator;
import java.util.List;

public interface IRoomManager {

    public void setImportRooms(List<Room> list);

    public List<Room> getRooms();

    public Integer getIdByNumberOnList(Integer number);

    public void deserializeData();

    public void serializeData();

    public void createRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, Integer id, RoomStatus status);

    public void changeRoomPrice(Integer numberOfRoom, Integer price);

    public void changeRoomStatus(Integer numberOfRoom, RoomStatus status);

    public void changeNumberOfStars(Integer numberOfRoom, Integer numberOfStars);

    public void changeCapacity(Integer numberOfRoom, Integer capacity);

    public void changeRoomBusy(Integer numberOfRoom, Boolean busy);

    public void copyRoom(Integer numberOfRoom, Integer newId, Integer newNumber);

    public Integer getNumberEmptyRoomInHotel();

    public Room getRoom(Integer numberOfRoom);

    public List<Room> getDetailsOfRoom(Integer numberOfRoom);

    public void sorting(Comparator comparator1, Comparator comparator2);

    public void sorting(Comparator comparator);

}
