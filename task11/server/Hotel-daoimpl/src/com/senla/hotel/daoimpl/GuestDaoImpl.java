/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.daoimpl;

import com.senla.hotel.api.dao.IGuestDao;
import com.senla.hotel.dbconnection.DbConnection;
import com.senla.hotel.entity.Guest;
import com.senla.hotel.enums.SortName;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

public class GuestDaoImpl implements IGuestDao {

    private final DbConnection dbConnection = DbConnection.getInstance();
    private static final Logger logger = Logger.getLogger(GuestDaoImpl.class);

    public GuestDaoImpl() {

    }

    @Override
    public Guest createMiracleGuest(String name, Date arrivalDate, Date dateOfDeparture) {
        Guest miracleGuest = new Guest(name, arrivalDate, dateOfDeparture, null);

        return miracleGuest;
    }
    @Override
    public List<Guest> getById(List<Integer> id) {
        List<Guest> guests = new ArrayList();
        for (Integer id1 : id) {
            guests.add(getById(id1));
        }
        return guests;
    }
    @Override
    public List<Guest> getAll(String sortName) {
        try (Statement statement = dbConnection.getConnection().createStatement()) {
            List<Guest> list = new ArrayList<>();
            ResultSet rs;
            if ("zero".equals(sortName)) {
                rs = statement.executeQuery(
                        "SELECT * FROM guest");
            } else {
                rs = statement.executeQuery(
                        "SELECT * FROM guest order by " + sortName);
            }

            while (rs.next()) {
                Guest guest = new Guest(rs.getString("name"), rs.getDate("arrivalDate"), rs.getDate("departureDate"), rs.getInt("idguest"));
                list.add(guest);
            }
            return list;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void setImportGuests(List<Guest> list) {
        try (Statement statement = dbConnection.getConnection().createStatement()) {

            for (int i = 0; i < list.size(); i++) {
                ResultSet result1 = statement.executeQuery(
                        "SELECT name FROM guest where idguest =" + list.get(i).getId());
                if (result1.next()) {
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
        return getAll(SortName.zero.toString()).get(number).getId();
    }

    @Override
    public Guest getById(Integer id) {
        try (Statement statement = dbConnection.getConnection().createStatement();) {
            Guest guest = null;
            ResultSet rs = statement.executeQuery(
                    "SELECT * FROM guest where idguest =" + id);
            while (rs.next()) {
                guest = new Guest(rs.getString("name"), rs.getDate("arrivalDate"), rs.getDate("departureDate"), rs.getInt("idguest"));
            }
            return guest;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void update(Guest entity) {
        try {
            try (PreparedStatement ps = dbConnection.getConnection().prepareStatement("update guest set name=?,arrivaldate=?,departuredate=? where idguest=?")) {
                ps.setString(1, entity.getName());
                ps.setDate(2, new java.sql.Date(entity.getArrivalDate().getTime()));
                ps.setDate(3, new java.sql.Date(entity.getDateOfDeparture().getTime()));
                ps.setInt(4, entity.getId());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public void create(Guest entity) {
        try {

            try (PreparedStatement ps = dbConnection.getConnection().prepareStatement("insert into guest(name,arrivaldate,departuredate) values (?,?,?)")) {
                ps.setString(1, entity.getName());
                ps.setDate(2, new java.sql.Date(entity.getArrivalDate().getTime()));
                ps.setDate(3, new java.sql.Date(entity.getDateOfDeparture().getTime()));
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

}
