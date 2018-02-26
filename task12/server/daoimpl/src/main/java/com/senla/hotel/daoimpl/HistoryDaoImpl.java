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
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class HistoryDaoImpl extends AbstractDao<History> implements IHistoryDao {

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
            Integer days = (int) (guest.getDepartureDate().getTime() - guest.getArrivalDate().getTime()) / (24 * 60 * 60 * 1000);
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
    public List<Service> getServices(Session session, Guest guest, Room room, String sort) {
        List<History> list;
        Criteria criteria;
        if ("zero".equals(sort)) {
            criteria = session.createCriteria(History.class).add(Restrictions.eq("guest", guest)).add(Restrictions.eq("room", room)).add(Restrictions.eq("enable", false));
        } else {
            criteria = session.createCriteria(History.class).add(Restrictions.eq("guest", guest)).add(Restrictions.eq("room", room)).add(Restrictions.eq("enable", false)).addOrder(Order.asc(sort));
        }
        list = criteria.list();
        return list.get(0).getService();
    }

    @Override
    public History getMiracleHistory(Guest guest, Room room) {
        History miracleHistory = new History();
        miracleHistory.setGuest(guest);
        miracleHistory.setRoom(room);
        return miracleHistory;
    }

    @Override
    protected List<History> parseQueryGetById(Session session, int id) throws SQLException {
        Criteria criteria = session.createCriteria(History.class).add(Restrictions.idEq(id));
        return criteria.list();
    }

    @Override
    protected List<History> parseQueryGetSortingAllEntity(Session ps, String condition) throws SQLException {

        return null;
    }

    @Override
    protected List<History> parseQueryGetAllEntity(Session ps) throws SQLException {

        return null;
    }

}
