/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.daoimpl;

import com.senla.hotel.api.dao.IHistoryDao;
import com.senla.hotel.dbconnection.DbConnection;
import com.senla.hotel.entity.Guest;
import com.senla.hotel.entity.History;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

public class HistoryDaoImpl implements IHistoryDao {

    private final DbConnection dbConnection = DbConnection.getInstance();
    private static Logger logger = Logger.getLogger(HistoryDaoImpl.class);

    @Override
    public List<Integer> getIdSortingServices(Room room, Guest guest, String sort) {
        try (Statement statement = dbConnection.getConnection().createStatement()) {
            List<Integer> list = new ArrayList();

            ResultSet rs = statement.executeQuery(
                    "SELECT service.idservice from service,services where idhistory =(SELECT idhistory FROM history where idguest=" + guest.getId() + " and idroom=" + room.getId() + " and enable=0) and service.idService=services.idService order by " + sort);
            while (rs.next()) {
                list.add(rs.getInt("idservice"));
            }
            return list;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
        return null;
    }

    @Override
    public void create(History entity) {
        try {
            try (PreparedStatement ps = dbConnection.getConnection().prepareStatement("insert into history(idRoom,idGuest,enable) values (?,?,?)")) {

                ps.setInt(1, entity.getRoom().getId());
                ps.setInt(2, entity.getGuest().getId());
                ps.setBoolean(3, false);
                ps.executeUpdate();
                dbConnection.getConnection().commit();
            }
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());

        }
    }

    @Override
    public void evictedFromRoom(History entity) {
        try {

            try (PreparedStatement ps = dbConnection.getConnection().prepareStatement("update history set enable=1 where idguest=? and idroom=?")) {
                ps.setInt(2, entity.getRoom().getId());
                ps.setInt(1, entity.getGuest().getId());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());

        }
    }

    @Override
    public Integer getPriceForAccommodation(Guest guest, Room room) {

        try (Statement statement = dbConnection.getConnection().createStatement()) {

            int amount = 0;
            Integer days = (int) (guest.getDateOfDeparture().getTime() - guest.getArrivalDate().getTime()) / (24 * 60 * 60 * 1000);
            ResultSet rs = statement.executeQuery(
                    "SELECT price from service,services where idhistory =(SELECT idhistory FROM history where idguest=" + guest.getId() + " and idroom=" + room.getId() + " and enable=0) and service.idService=services.idService");
            while (rs.next()) {

                amount = amount + rs.getInt("price");

            }

            Integer guestAmountForAccommodation = amount + room.getPrice() * days;
            return guestAmountForAccommodation;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
        return null;
    }

    @Override
    public Integer getNumberOfGuestInHotel() {
        try (Statement statement = dbConnection.getConnection().createStatement()) {

            ResultSet rs = statement.executeQuery(
                    "SELECT COUNT(*) as number FROM history where enable =0");

            while (rs.next()) {
                return rs.getInt("number");
            }
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());

        }
        return null;
    }

    @Override
    public Boolean checForPresense(Room room) {
        Boolean presence = false;
        try (Statement statement = dbConnection.getConnection().createStatement()) {

            ResultSet rs = statement.executeQuery(
                    "SELECT idhistory FROM history where  idroom=" + room.getId() + " and enable=0");
            while (rs.next()) {
                presence = true;
            }
            return presence;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Integer> getListLeftGuest(Room room, Integer count) {
        List<Integer> list = new ArrayList();
        try (Statement statement = dbConnection.getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(
                    "SELECT idguest FROM history where enable =1 and idroom =" + room.getId() + " limit " + count);
            while (rs.next()) {

                list.add(rs.getInt("idguest"));
            }
            return list;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Integer> getIdRoomsAvalableByDate(Date date) {

        List<Integer> list = new ArrayList();
        try (Statement statement = dbConnection.getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(
                    "SELECT idroom FROM history,guest where enable = 0 and " + new java.sql.Date(date.getTime()) + "  between (guest.departuredate and guest.arrivaldate) and guest.idGuest=history.idguest ");
            while (rs.next()) {
                list.add(rs.getInt("idroom"));
            }
            return list;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void setService(Guest guest, Room room, Service service) {
        try (Statement statement = dbConnection.getConnection().createStatement()) {

            ResultSet rs = statement.executeQuery(
                    "SELECT idhistory FROM history where idguest=" + guest.getId() + " and idroom=" + room.getId() + " and enable=0");

            while (rs.next()) {
                PreparedStatement ps = dbConnection.getConnection().prepareStatement("insert into services(idhistory,idservice) values (?,?)");
                ps.setInt(1, rs.getInt("idhistory"));
                ps.setInt(2, service.getId());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public History getMiracleHistory(Guest guest, Room room) {
        History miracleHistory = new History();
        miracleHistory.setGuest(guest);
        miracleHistory.setRoom(room);
        return miracleHistory;
    }

}
