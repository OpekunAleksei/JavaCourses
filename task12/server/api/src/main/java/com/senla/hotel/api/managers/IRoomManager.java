/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.managers;

import com.senla.hotel.entity.Room;

import java.sql.SQLException;
import java.util.List;

public interface IRoomManager {

    public void setImportRooms(List<Room> list) throws SQLException;

    public List<Room> getRooms() throws SQLException;

    public Integer getIdByNumberOnList(Integer number) throws SQLException;

    public void createRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, String status) throws SQLException;

    public void changeRoomPrice(Integer numberOfRoom, Integer price) throws SQLException;

    public void changeRoomStatus(Integer numberOfRoom, String status) throws SQLException;

    public void changeNumberOfStars(Integer numberOfRoom, Integer numberOfStars) throws SQLException;

    public void changeCapacity(Integer numberOfRoom, Integer capacity) throws SQLException;

    public void changeRoomBusy(Integer numberOfRoom, Boolean busy) throws SQLException;

    public void copyRoom(Integer numberOfRoom, Integer newNumber) throws SQLException, CloneNotSupportedException;

    public Integer getNumberEmptyRoomInHotel() throws SQLException;

    public Room getRoom(Integer numberOfRoom) throws SQLException;

    public List<Room> getDetailsOfRoom(Integer numberOfRoom) throws SQLException;

    public List<Room> getListRooms(String name, String busy) throws SQLException;

}
