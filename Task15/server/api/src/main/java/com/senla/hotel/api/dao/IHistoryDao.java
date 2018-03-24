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
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

public interface IHistoryDao extends IGenericDao<History> {

    public void setService(Session session, Guest guest, Room room, Service service) throws SQLException;

    public Long getPriceForAccommodation(Session session, Guest guest, Room room) throws SQLException;

    public Integer getNumberOfGuestInHotel(Session session) throws SQLException;

    public Boolean checForPresense(Session session, Room room) throws SQLException;

    public List<Guest> getListLeftGuest(Session session, Room room, Integer count) throws SQLException;

    public List<Room> getIdRoomsAvalableByDate(Session session, Date date) throws SQLException;

    public History getHistory(Session session, Guest guest, Room room);

    public List<Service> getGuestService(Session session, Guest guest, Room room, String sortName);
}
