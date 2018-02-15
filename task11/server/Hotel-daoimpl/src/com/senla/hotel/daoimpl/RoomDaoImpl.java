/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.daoimpl;

import com.senla.hotel.api.dao.IRoomDao;
import com.senla.hotel.dbconnection.DbConnection;
import com.senla.hotel.entity.Room;
import com.senla.hotel.enums.RoomStatus;
import com.senla.hotel.utils.Converter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

public class RoomDaoImpl implements IRoomDao {

    private final DbConnection dbConnection = DbConnection.getInstance();
    private final Converter sc = new Converter();
    private static Logger logger = Logger.getLogger(RoomDaoImpl.class);
    private Boolean empty;

    public RoomDaoImpl() {

        this.empty = false;
    }

    @Override
    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }

    @Override
    public List<Room> getMiracleRoomList(Integer id) {
        List<Room> miracleList = new ArrayList();
        miracleList.add(getById(id));
        return miracleList;
    }

    @Override
    public Room createMiracleRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, RoomStatus status) {
        Room miracleRoom = new Room(number, price, capacity, numberOfStars, null, status, false);
        return miracleRoom;
    }

    @Override
    public List<Room> getById(List<Integer> id) {
        List<Room> rooms = new ArrayList();
        for (Integer id1 : id) {
            rooms.add(getById(id1));
        }
        return rooms;
    }

    @Override
    public List<Room> getAll(String sortName) {
        try (Statement statement = dbConnection.getConnection().createStatement()) {
            List<Room> list = new ArrayList<>();
            ResultSet rs;
            String condition;
            if (empty == false) {
                condition = "where busy=1 ";
            } else {
                condition = "";
            }
            if ("zero".equals(sortName)) {
                rs = statement.executeQuery(
                        "SELECT * FROM room " + condition);
            } else {
                rs = statement.executeQuery(
                        "SELECT * FROM room " + condition + "order by " + sortName);
            }

            while (rs.next()) {
                Room room = new Room(rs.getInt("number"), rs.getInt("price"), rs.getInt("capacity"), rs.getInt("numberofstars"), rs.getInt("idroom"), sc.getStatus(rs.getString("status")), sc.booleanConverter(rs.getInt("busy")));
                list.add(room);
            }
            return list;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Integer getNumberEmptyRoom() {

        try (Statement statement = dbConnection.getConnection().createStatement()) {

            ResultSet rs = statement.executeQuery(
                    "SELECT COUNT(*) as number FROM room where busy =1");
            rs.next();
            return rs.getInt("number");

        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void copyRoom(Integer numberOfRoom, Integer newNumber) {
        Room copyRoom;
        try {
            copyRoom = (Room) (getById(numberOfRoom)).clone();
            copyRoom.setNumber(newNumber);
            copyRoom.setBusy(Boolean.FALSE);
            create(copyRoom);
        } catch (CloneNotSupportedException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public void changePartOfRoom(Integer id, Object changeVariable, String name) {
        try {

            try (PreparedStatement ps = dbConnection.getConnection().prepareStatement("update room set " + name + "=? where number=?")) {
                if (changeVariable.getClass() == RoomStatus.class) {
                    changeVariable = changeVariable.toString();
                } else if ("true".equals(changeVariable.toString())) {
                    changeVariable = false;
                } else if ("false".equals(changeVariable.toString())) {
                    changeVariable = true;
                } else {
                    ps.setObject(1, changeVariable);
                }
                ps.setInt(2, id);

                ps.executeUpdate();
            }
        } catch (SQLException ex) {

            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public List<Room> getSortingListOfRooms(String name, Boolean empty) {

        try (Statement statement = dbConnection.getConnection().createStatement()) {
            ResultSet rs;
            List<Room> list = new ArrayList<>();
            if (!empty) {
                rs = statement.executeQuery(
                        "SELECT * FROM room where busy=1  order by " + name);
            } else {
                rs = statement.executeQuery(
                        "SELECT * FROM room order by " + name);
            }
            while (rs.next()) {

                Room room = new Room(rs.getInt("number"), rs.getInt("price"), rs.getInt("capacity"), rs.getInt("numberofstars"), rs.getInt("idroom"), sc.getStatus(rs.getString("status")), sc.booleanConverter(rs.getInt("busy")));
                list.add(room);
            }
            return list;

        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void setImportRooms(List<Room> list) {
        try (Statement statement = dbConnection.getConnection().createStatement()) {

            for (int i = 0; i < list.size(); i++) {
                ResultSet rs = statement.executeQuery(
                        "SELECT number FROM room where idroom =" + list.get(i).getId());
                if (rs.next()) {
                    update(list.get(i));
                } else {
                    create(list.get(i));
                }

            }
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }

    }

    @Override
    public Integer getIdByNumberOnlist(Integer number) {

        return getAll(null).get(number).getNumber();
    }

    @Override
    public Room getById(Integer id) {
        try (Statement statement = dbConnection.getConnection().createStatement()) {
            Room room = null;
            ResultSet rs = statement.executeQuery(
                    "SELECT * FROM room where number =" + id);
            while (rs.next()) {
                room = new Room(rs.getInt("number"), rs.getInt("price"), rs.getInt("capacity"), rs.getInt("numberofstars"), rs.getInt("idroom"), sc.getStatus(rs.getString("status")), sc.booleanConverter(rs.getInt("busy")));
            }
            return room;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void update(Room entity) {
        try {
            try (PreparedStatement ps = dbConnection.getConnection().prepareStatement("update room set price=?,number=?,busy=?,capacity=?,numberofstars=?,status=? where idroom=?")) {
                ps.setInt(1, entity.getPrice());
                ps.setInt(2, entity.getNumber());
                ps.setBoolean(3, !entity.getBusy());
                ps.setInt(4, entity.getCapacity());
                ps.setInt(5, entity.getNumberOfStars());
                ps.setString(6, entity.getStatus().toString());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public void create(Room entity) {
        try {
            try (PreparedStatement ps = dbConnection.getConnection().prepareStatement("insert into room(number,price,busy,capacity,numberofstars,status) values (?,?,?,?,?,?)")) {
                ps.setInt(2, entity.getPrice());
                ps.setInt(1, entity.getNumber());
                ps.setBoolean(3, !entity.getBusy());
                ps.setInt(4, entity.getCapacity());
                ps.setInt(5, entity.getNumberOfStars());
                ps.setString(6, entity.getStatus().toString());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

}
