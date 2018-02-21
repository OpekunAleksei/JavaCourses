/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.daoimpl;

import com.senla.hotel.api.dao.IHistoryDao;
import com.senla.hotel.entity.Guest;
import com.senla.hotel.entity.History;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

public class HistoryDaoImpl extends AbstractDao<History> implements IHistoryDao {

    private final static String GET_ALL = "SELECT * FROM history";

    private final static String INSERT_HISTORY = "insert into history(idRoom,idGuest,enable) values (?,?,?)";
    private final static String UPDATE_HISTORY = "update history set enable=1 where idguest=? and idroom=?";
    private final static String GET_BY_ID = "SELECT * FROM history where ihistory = ?";
    private final static String DELETE_HISTORY = "DELETE from history where idhistory=?";
    private static Logger logger = Logger.getLogger(HistoryDaoImpl.class);

    @Override
    public List<Integer> getIdSortingServices(Connection connection, Room room, Guest guest, String sort) throws SQLException {
        String SQLQuery = "SELECT service.idservice from service,services where idhistory =(SELECT idhistory FROM history where idguest=" + guest.getId() + " and idroom=" + room.getId() + " and enable=0) and service.idService=services.idService order by " + sort;
        try (Statement statement = connection.createStatement()) {
            List<Integer> list = new ArrayList();

            ResultSet rs = statement.executeQuery(SQLQuery);
            while (rs.next()) {
                list.add(rs.getInt("idservice"));
            }
            return list;
        }
    }

    @Override
    public Integer getPriceForAccommodation(Connection connection, Guest guest, Room room) throws SQLException {
        String SQLQuery = "SELECT price from service,services where idhistory =(SELECT idhistory FROM history where idguest=" + guest.getId() + " and idroom=" + room.getId() + " and enable=0) and service.idService=services.idService";
        try (Statement statement = connection.createStatement()) {
            int amount = 0;
            Integer days = (int) (guest.getDateOfDeparture().getTime() - guest.getArrivalDate().getTime()) / (24 * 60 * 60 * 1000);
            ResultSet rs = statement.executeQuery(SQLQuery);
            while (rs.next()) {
                amount = amount + rs.getInt("price");
            }
            Integer guestAmountForAccommodation = amount + room.getPrice() * days;
            return guestAmountForAccommodation;
        }
    }

    @Override
    public Integer getNumberOfGuestInHotel(Connection connection) throws SQLException {
        String SQLQuery = "SELECT COUNT(*) as number FROM history where enable =0";
        try (Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(SQLQuery);
            while (rs.next()) {
                return rs.getInt("number");
            }
        }
        return null;
    }

    @Override
    public Boolean checForPresense(Connection connection, Room room) throws SQLException {
        Boolean presence = false;
        String SQLQuery = "SELECT idhistory FROM history where  idroom=" + room.getId() + " and enable=0";
        try (Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(SQLQuery);
            while (rs.next()) {
                presence = true;
            }
            return presence;
        }
    }

    @Override
    public List<Integer> getListLeftGuest(Connection connection, Room room, Integer count) throws SQLException {
        String SQLQuery = "SELECT idguest FROM history where enable =1 and idroom =" + room.getId() + " limit " + count;
        List<Integer> list = new ArrayList();
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQLQuery);
            while (rs.next()) {

                list.add(rs.getInt("idguest"));
            }
            return list;
        }
    }

    @Override
    public List<Integer> getIdRoomsAvalableByDate(Connection connection, Date date) throws SQLException {
        String SQLQuery = "SELECT idroom FROM history,guest where enable = 0 and " + new java.sql.Date(date.getTime()) + "  between (guest.departuredate and guest.arrivaldate) and guest.idGuest=history.idguest ";
        List<Integer> list = new ArrayList();
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQLQuery);
            while (rs.next()) {
                list.add(rs.getInt("idroom"));
            }
            return list;
        }
    }

    @Override
    public void setService(Connection connection, Guest guest, Room room, Service service) throws SQLException {
        String SQLQuery = "insert into services(idhistory,idservice) values ((SELECT idhistory FROM history where idguest=" + guest.getId() + " and idroom=" + room.getId() + " and enable=0),?)";
        try (PreparedStatement ps = connection.prepareStatement(SQLQuery)) {
            ps.setInt(1, service.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public History getMiracleHistory(Guest guest, Room room) {
        History miracleHistory = new History();
        miracleHistory.setGuest(guest);
        miracleHistory.setRoom(room);
        return miracleHistory;
    }

    @Override
    protected String getByIdQuery() {
        return GET_BY_ID;
    }

    @Override
    protected String getUpdateQuery() {
        return UPDATE_HISTORY;
    }

    @Override
    protected String getCreateQuery() {
        return INSERT_HISTORY;
    }

    @Override
    protected String getAllQuery() {
        return GET_ALL;
    }

    @Override
    protected String getDeleteQuery() {
        return DELETE_HISTORY;
    }

    @Override
    protected String getSortingAllQuery() {
        return GET_ALL;
    }

    @Override
    protected List<History> parseQueryGetById(PreparedStatement ps, int id) throws SQLException {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        return parseQueryGetList(rs);
    }

    private List<History> parseQueryGetList(ResultSet rs) throws SQLException {
        List<History> historys = new ArrayList();
        while (rs.next()) {
            History history = new History();
            historys.add(history);
        }
        return historys;
    }

    @Override
    protected void parseQueryCreateEntity(PreparedStatement ps, History object) throws SQLException {
        ps.setInt(1, object.getRoom().getId());
        ps.setInt(2, object.getGuest().getId());
        ps.setBoolean(3, false);
    }

    @Override
    protected List<History> parseQueryGetSortingAllEntity(PreparedStatement ps, String condition) throws SQLException {
        ResultSet rs = ps.executeQuery();
        return parseQueryGetList(rs);
    }

    @Override
    protected List<History> parseQueryGetAllEntity(PreparedStatement ps) throws SQLException {
        ResultSet rs = ps.executeQuery();
        return parseQueryGetList(rs);
    }

    @Override
    protected void parseQueryDeleteEntity(PreparedStatement ps, History object) throws SQLException {
        ps.setInt(1, object.getId());
    }

    @Override
    protected void parseQueryUpdateEntity(PreparedStatement ps, History object) throws SQLException {
        ps.setInt(2, object.getRoom().getId());
        ps.setInt(1, object.getGuest().getId());
    }

}
