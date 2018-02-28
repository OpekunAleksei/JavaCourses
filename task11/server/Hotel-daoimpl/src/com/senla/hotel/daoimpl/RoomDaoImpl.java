/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.daoimpl;

import com.senla.hotel.api.dao.IRoomDao;
import com.senla.hotel.entity.Room;
import com.senla.hotel.enums.RoomStatus;
import com.senla.hotel.utils.Converter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
=======
import org.apache.log4j.Logger;
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

public class RoomDaoImpl extends AbstractDao<Room> implements IRoomDao {

    private final Converter sc = new Converter();
<<<<<<< HEAD

=======
    private static Logger logger = Logger.getLogger(RoomDaoImpl.class);
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a
    private Boolean empty;
    private final static String GET_ALL = "SELECT * FROM room ";
    private final static String INSERT_ROOM = "insert into room(number,price,busy,capacity,numberofstars,status) values (?,?,?,?,?,?)";
    private final static String UPDATE_ROOM = "update room set price=?,number=?,busy=?,capacity=?,numberofstars=?,status=? where idroom=?";
    private final static String GET_BY_ID = "SELECT * FROM room where number =?";
    private final static String DELETE_ROOM = "DELETE from room where idroom=?";

    public RoomDaoImpl() {

        this.empty = false;
    }

    @Override
    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }

    @Override
    public List<Room> getMiracleRoomList(Connection connection, Integer id) throws SQLException {
        List<Room> miracleList = new ArrayList();
        miracleList.add(getById(connection, id));
        return miracleList;
    }

    @Override
    public Room createMiracleRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, RoomStatus status) {
        Room miracleRoom = new Room(number, price, capacity, numberOfStars, null, status, false);
        return miracleRoom;
    }

    @Override
    public Integer getNumberEmptyRoom(Connection connection) throws SQLException {
        String SQLQuery = "SELECT COUNT(*) as number FROM room where busy =1";
        try (Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(SQLQuery);
            rs.next();
            return rs.getInt("number");

        }
    }

    @Override
    public void copyRoom(Connection connection, Integer numberOfRoom, Integer newNumber) throws SQLException, CloneNotSupportedException {
        Room copyRoom;
        copyRoom = (Room) (getById(connection, numberOfRoom)).clone();
        copyRoom.setNumber(newNumber);
        copyRoom.setBusy(Boolean.FALSE);
        create(connection, copyRoom);
    }

    @Override
    public void changePartOfRoom(Connection connection, Integer id, Object changeVariable, String name) throws SQLException {
        String SQLQuery = "update room set " + name + "=? where number=?";
        try (PreparedStatement ps = connection.prepareStatement(SQLQuery)) {
            if (changeVariable.getClass() == RoomStatus.class) {
                changeVariable = changeVariable.toString();
            } else if ("true".equals(changeVariable.toString())) {
                changeVariable = false;
            } else if ("false".equals(changeVariable.toString())) {
                changeVariable = true;
            }
            ps.setObject(1, changeVariable);
            ps.setInt(2, id);
            ps.executeUpdate();
        }

    }

    @Override
    public void setImportRooms(Connection connection, List<Room> list) throws SQLException {

        try (Statement statement = connection.createStatement()) {

            for (int i = 0; i < list.size(); i++) {

                ResultSet rs = statement.executeQuery(
                        "SELECT number FROM room where idroom =" + list.get(i).getId());
                if (rs.next()) {
                    update(connection, list.get(i));
                } else {
                    create(connection, list.get(i));
                }
            }
        }

    }

    @Override
    public Integer getIdByNumberOnlist(Connection connection, Integer number) throws SQLException {

        return getAll(connection, "zero").get(number).getNumber();
    }

    @Override
    protected String getByIdQuery() {

        return GET_BY_ID;
    }

    @Override
    protected String getUpdateQuery() {
        return UPDATE_ROOM;
    }

    @Override
    protected String getCreateQuery() {
        return INSERT_ROOM;
    }

    @Override
    protected String getAllQuery() {
        if (empty == false) {
            return GET_ALL + "where busy=1";
        } else {
            return GET_ALL;
        }

    }

    @Override
    protected String getSortingAllQuery() {
        if (empty == false) {
            return GET_ALL + " where busy=1 " + " order by ?";
        } else {
            return GET_ALL;
        }

    }

    @Override
    protected List<Room> parseQueryGetById(PreparedStatement ps, int id) throws SQLException {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        return parseQueryGetList(rs);
    }

    @Override
    protected List<Room> parseQueryGetSortingAllEntity(PreparedStatement ps, String condition) throws SQLException {
        ps.setString(1, condition);
        ResultSet rs = ps.executeQuery();
        return parseQueryGetList(rs);
    }

    private List<Room> parseQueryGetList(ResultSet rs) throws SQLException {

        List<Room> list = new ArrayList();
        while (rs.next()) {
            Room room = new Room(rs.getInt("number"), rs.getInt("price"), rs.getInt("capacity"), rs.getInt("numberofstars"), rs.getInt("idroom"), sc.getStatus(rs.getString("status")), sc.booleanConverter(rs.getInt("busy")));
            list.add(room);
        }
        return list;
    }

    @Override
    protected void parseQueryCreateEntity(PreparedStatement ps, Room object) throws SQLException {
        ps.setInt(1, object.getPrice());
        ps.setInt(2, object.getNumber());
        ps.setBoolean(3, !object.getBusy());
        ps.setInt(4, object.getCapacity());
        ps.setInt(5, object.getNumberOfStars());
        ps.setString(6, object.getStatus().toString());
    }

    @Override
    protected void parseQueryUpdateEntity(PreparedStatement ps, Room object) throws SQLException {
        ps.setInt(1, object.getPrice());
        ps.setInt(2, object.getNumber());
        ps.setBoolean(3, !object.getBusy());
        ps.setInt(4, object.getCapacity());
        ps.setInt(5, object.getNumberOfStars());
        ps.setString(6, object.getStatus().toString());
        ps.setInt(6, object.getId());
    }

    @Override
    protected List<Room> parseQueryGetAllEntity(PreparedStatement ps) throws SQLException {

        ResultSet rs = ps.executeQuery();
        return parseQueryGetList(rs);
    }

    @Override
    protected String getDeleteQuery() {
        return DELETE_ROOM;
    }

    @Override
    protected void parseQueryDeleteEntity(PreparedStatement ps, Room object) throws SQLException {
        ps.setInt(1, object.getId());
    }

}
