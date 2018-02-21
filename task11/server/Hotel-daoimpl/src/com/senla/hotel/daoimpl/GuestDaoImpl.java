/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.daoimpl;

import com.senla.hotel.api.dao.IGuestDao;
import com.senla.hotel.entity.Guest;
import com.senla.hotel.enums.SortName;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

public class GuestDaoImpl extends AbstractDao<Guest> implements IGuestDao {

    private static final Logger logger = Logger.getLogger(GuestDaoImpl.class);
    private final static String GET_ALL = "SELECT * FROM guest";
    private final static String GET_SORTING_ALL = "SELECT * FROM guest order by  ?";
    private final static String INSERT_GUEST = "insert into guest(name,arrivaldate,departuredate) values (?,?,?)";
    private final static String UPDATE_GUEST = "update guest set name=?,arrivaldate=?,departuredate=? where idguest=?";
    private final static String GET_BY_ID = "SELECT * FROM guest where idguest = ?";
    private final static String DELETE_GUEST = "DELETE from guest where idguest=?";

    public GuestDaoImpl() {

    }

    @Override
    public Guest createMiracleGuest(String name, Date arrivalDate, Date dateOfDeparture) {
        Guest miracleGuest = new Guest(name, arrivalDate, dateOfDeparture, null);

        return miracleGuest;
    }

    @Override
    public void setImportGuests(Connection connection, List<Guest> list) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            for (int i = 0; i < list.size(); i++) {
                ResultSet result1 = statement.executeQuery(
                        "SELECT name FROM guest where idguest =" + list.get(i).getId());
                if (result1.next()) {
                    update(connection, list.get(i));
                } else {
                    create(connection, list.get(i));
                }
            }
        }
    }

    @Override
    public Integer getIdByNumberOnlist(Connection connection, Integer number) throws SQLException {
        return getAll(connection, SortName.zero.toString()).get(number).getId();
    }

    @Override
    protected String getByIdQuery() {
        return GET_BY_ID;
    }

    @Override
    protected String getUpdateQuery() {
        return UPDATE_GUEST;
    }

    @Override
    protected String getCreateQuery() {
        return INSERT_GUEST;
    }

    @Override
    protected String getAllQuery() {
        return GET_ALL;
    }

    @Override
    protected List<Guest> parseQueryGetById(PreparedStatement ps, int id) throws SQLException {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        return parseQueryGetList(rs);
    }

    @Override
    protected List<Guest> parseQueryGetSortingAllEntity(PreparedStatement ps, String condition) throws SQLException {
        ps.setString(1, condition);
        ResultSet rs = ps.executeQuery();
        return parseQueryGetList(rs);
    }

    private List<Guest> parseQueryGetList(ResultSet rs) throws SQLException {
        List<Guest> guests = new ArrayList();
        while (rs.next()) {
            Guest guest = new Guest(rs.getString("name"), rs.getDate("arrivalDate"), rs.getDate("departureDate"), rs.getInt("idguest"));
            guests.add(guest);
        }
        return guests;
    }

    @Override
    protected void parseQueryCreateEntity(PreparedStatement ps, Guest object) throws SQLException {
        ps.setString(1, object.getName());
        ps.setDate(2, new java.sql.Date(object.getArrivalDate().getTime()));
        ps.setDate(3, new java.sql.Date(object.getDateOfDeparture().getTime()));

    }

    @Override
    protected void parseQueryUpdateEntity(PreparedStatement ps, Guest object) throws SQLException {
        ps.setString(1, object.getName());
        ps.setDate(2, new java.sql.Date(object.getArrivalDate().getTime()));
        ps.setDate(3, new java.sql.Date(object.getDateOfDeparture().getTime()));
        ps.setInt(4, object.getId());
    }

    @Override
    protected String getSortingAllQuery() {
        return GET_SORTING_ALL;
    }

    @Override
    protected List<Guest> parseQueryGetAllEntity(PreparedStatement ps) throws SQLException {
        ResultSet rs = ps.executeQuery();
        return parseQueryGetList(rs);
    }

    @Override
    protected String getDeleteQuery() {
        return DELETE_GUEST;
    }

    @Override
    protected void parseQueryDeleteEntity(PreparedStatement ps, Guest object) throws SQLException {
        ps.setInt(1, object.getId());
    }

}
