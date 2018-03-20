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
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class HistoryDaoImpl extends AbstractDao<History> implements IHistoryDao {

    public HistoryDaoImpl() {
        super(new History());
    }

    @Override
    public Long getPriceForAccommodation(Session session, Guest guest, Room room) throws SQLException {
        History history = getHistory(session, guest, room);
        List<Service> list = history.getService();
        int amount = 0;
        Long days = (history.getGuest().getDepartureDate().getTime() - history.getGuest().getArrivalDate().getTime()) / (24 * 60 * 60 * 1000);
        for (Service service : list) {
            amount = amount + service.getPrice();
        }
        Long guestAmountForAccommodation = amount + history.getRoom().getPrice() * days;
        return guestAmountForAccommodation;
    }

    @Override
    public Integer getNumberOfGuestInHotel(Session session) throws SQLException {
        Criteria criteria = session.createCriteria(History.class).add(Restrictions.eq("enable", false));
        return criteria.list().size();
    }

    @Override
    public Boolean checForPresense(Session session, Room room) throws SQLException {
        Criteria criteria = session.createCriteria(History.class).add(Restrictions.eq("room", room)).add(Restrictions.eq("enable", false));
        return !criteria.list().isEmpty();

    }

    @Override
    public List<Guest> getListLeftGuest(Session session, Room room, Integer count) throws SQLException {
        Criteria criteria = session.createCriteria(Guest.class).setMaxResults(count).createCriteria("history").add(Restrictions.eq("room", room)).add(Restrictions.eq("enable", true));
        return criteria.list();
    }

    @Override
    public List<Room> getIdRoomsAvalableByDate(Session session, Date date) throws SQLException {
        Criteria criteria = session.createCriteria(Room.class).createCriteria("history").createCriteria("guest").add(Restrictions.lt("arrivaldate", date)).add(Restrictions.gt("deprturedate", date));
        return criteria.list();

    }

    @Override
    public void setService(Session session, Guest guest, Room room, Service service) throws SQLException {
        History history = getHistory(session, guest, room);
        history.getService().add(service);
        update(session, history);

    }

    @Override
    public List<Service> getGuestService(Session session, Guest guest, Room room, String sortName) {
        Criteria criteria = session.createCriteria(Service.class
        ).addOrder(Order.asc(sortName)).createCriteria("history").add(Restrictions.eq("guest", guest)).add(Restrictions.eq("room", room)).add(Restrictions.eq("enable", false));
        return criteria.list();
    }

    @Override
    public History
            getHistory(Session session, Guest guest, Room room) {
        Criteria criteria = session.createCriteria(History.class
        ).add(Restrictions.eq("guest", guest)).add(Restrictions.eq("room", room)).add(Restrictions.eq("enable", false));
        return (History) criteria.list().get(0);
    }

    @Override
    public History getMiracleHistory(Guest guest, Room room, Boolean enable) {
        History miracleHistory = new History();
        miracleHistory.setGuest(guest);
        miracleHistory.setRoom(room);
        miracleHistory.setEnable(enable);
        return miracleHistory;
    }

    @Override
    public History getMiracleHistory(Session session, Guest guest, Room room, Boolean enable) {
        History miracleHistory = getHistory(session, guest, room);
        miracleHistory.setEnable(enable);
        return miracleHistory;
    }

}
