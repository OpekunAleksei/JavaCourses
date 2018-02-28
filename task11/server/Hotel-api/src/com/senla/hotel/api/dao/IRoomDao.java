/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.dao;

import com.senla.hotel.entity.Room;
import com.senla.hotel.enums.RoomStatus;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.List;

public interface IRoomDao extends IGenericDao<Room> {

    public void setImportRooms(Connection connection, List<Room> list) throws SQLException;

    public Integer getIdByNumberOnlist(Connection connection, Integer number) throws SQLException;

    public Room createMiracleRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, RoomStatus status);

    public void copyRoom(Connection connection, Integer numberOfRoom, Integer newNumber) throws SQLException, CloneNotSupportedException;

    public Integer getNumberEmptyRoom(Connection connection) throws SQLException;

    public void changePartOfRoom(Connection connection, Integer numberOfRoom, Object object, String name) throws SQLException;

    public void setEmpty(Boolean busy);

    public List<Room> getMiracleRoomList(Connection connection, Integer id) throws SQLException;

}
