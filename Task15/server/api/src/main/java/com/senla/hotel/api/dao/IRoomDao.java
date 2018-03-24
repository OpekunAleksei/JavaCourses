/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.dao;

import com.senla.hotel.entity.Room;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;

public interface IRoomDao extends IGenericDao<Room> {

    public void setImportRooms(Session session, List<Room> list) throws SQLException;

    public Integer getIdByNumberOnlist(Session session, Integer number) throws SQLException;

    public Room copyRoom(Session session, Integer numberOfRoom, Integer newNumber) throws SQLException, CloneNotSupportedException;

    public Integer getNumberEmptyRoom(Session session) throws SQLException;

    public void changePartOfRoom(Session session, Integer numberOfRoom, Object object, String name) throws SQLException;

    public void setEmpty(Boolean busy);

    public List<Room> getMiracleRoomList(Session session, Integer id) throws SQLException;

}
