/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.managers;

import com.senla.hotel.entity.Room;

import java.util.List;

public interface IRoomManager {

    public void setImportRooms(List<Room> list) throws Exception;

    public List<Room> getRooms() throws Exception;

    public Integer getIdByNumberOnList(Integer number) throws Exception;

    public void createRoom(Room room) throws Exception;

    public void changeRoomPrice(Integer numberOfRoom, Integer price) throws Exception;

    public void changeRoomStatus(Integer numberOfRoom, String status) throws Exception;

    public void changeNumberOfStars(Integer numberOfRoom, Integer numberOfStars) throws Exception;

    public void changeCapacity(Integer numberOfRoom, Integer capacity) throws Exception;

    public void changeRoomBusy(Integer numberOfRoom, Boolean busy) throws Exception;

    public void copyRoom(Integer numberOfRoom, Integer newNumber) throws Exception, CloneNotSupportedException;

    public Integer getNumberEmptyRoomInHotel() throws Exception;

    public Room getRoom(Integer numberOfRoom) throws Exception;

    public List<Room> getDetailsOfRoom(Integer numberOfRoom) throws Exception;

    public List<Room> getListRooms(String name, Boolean busy) throws Exception;

}
