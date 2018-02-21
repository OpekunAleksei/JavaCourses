/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.dao;

import com.senla.hotel.entity.Guest;
import com.senla.hotel.entity.History;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IHistoryDao {

    public void create(Connection connection, History history) throws SQLException;

    public void evictedFromRoom(Connection connection, History history) throws SQLException;

    public void setService(Connection connection, Guest guest, Room room, Service service) throws SQLException;

    public Integer getPriceForAccommodation(Connection connection, Guest guest, Room room) throws SQLException;

    public Integer getNumberOfGuestInHotel(Connection connection) throws SQLException;

    public Boolean checForPresense(Connection connection, Room room) throws SQLException;

    public List<Integer> getListLeftGuest(Connection connection, Room room, Integer count) throws SQLException;

    public List<Integer> getIdRoomsAvalableByDate(Connection connection, Date date) throws SQLException;

    public List<Integer> getIdSortingServices(Connection connection, Room room, Guest guest, String sort) throws SQLException;

    public History getMiracleHistory(Guest guest, Room room);

}
