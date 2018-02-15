/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.dao;

import com.senla.hotel.entity.Room;
import com.senla.hotel.enums.RoomStatus;

import java.util.List;

public interface IRoomDao extends IGenericDao<Room> {

    public void setImportRooms(List<Room> list);

    public Integer getIdByNumberOnlist(Integer number);

    public Room createMiracleRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, RoomStatus status);

    public void copyRoom(Integer numberOfRoom, Integer newNumber);

    public Integer getNumberEmptyRoom();

    public List<Room> getSortingListOfRooms(String name, Boolean busy);

    public void changePartOfRoom(Integer numberOfRoom, Object object, String name);

    public void setEmpty(Boolean busy);

    public List<Room> getMiracleRoomList(Integer id);

    public List<Room> getById(List<Integer> id) ;
    }
