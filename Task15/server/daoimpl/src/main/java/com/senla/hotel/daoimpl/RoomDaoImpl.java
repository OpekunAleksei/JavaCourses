/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.daoimpl;

import com.senla.hotel.api.dao.IRoomDao;
import com.senla.hotel.entity.Room;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class RoomDaoImpl extends AbstractDao<Room> implements IRoomDao {

    private Boolean empty;

    public RoomDaoImpl() {
        super(new Room());
        this.empty = false;
    }

    @Override
    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }

    @Override
    public List<Room> getMiracleRoomList(Session session, Integer id) throws SQLException {
        List<Room> miracleList = new ArrayList();
        miracleList.add(getById(session, id));
        return miracleList;
    }

    @Override
    public Integer getNumberEmptyRoom(Session session) throws SQLException {
        Criteria criteria = session.createCriteria(Room.class).add(Restrictions.eq("busy", false));
        return criteria.list().size();

    }

    @Override
    public Room copyRoom(Session session, Integer numberOfRoom, Integer newNumber) throws SQLException, CloneNotSupportedException {
        Room copyRoom;
        copyRoom = (Room) (getById(session, numberOfRoom)).clone();
        copyRoom.setNumber(newNumber);
        copyRoom.setBusy(Boolean.FALSE);
        return copyRoom;
    }

    @Override
    public void changePartOfRoom(Session session, Integer id, Object changeVariable, String name) throws SQLException {
        if ("true".equals(changeVariable.toString())) {
            changeVariable = false;
        } else if ("false".equals(changeVariable.toString())) {
            changeVariable = true;
        }
        Query query = session.createQuery("Update com.senla.hotel.entity.Room set " + name + " = :variable where idroom = :roomId");
        query.setParameter("variable", changeVariable);
        query.setParameter("roomId", id);
        query.executeUpdate();
    }

    @Override
    public void setImportRooms(Session session, List<Room> list) throws SQLException {

        for (Room list1 : list) {
            session.saveOrUpdate(list1);
        }
    }

    @Override
    public Integer getIdByNumberOnlist(Session session, Integer number) throws SQLException {

        return getAll(session, "zero").get(number).getId();
    }

    @Override
    public List<Room> getAll(Session session, String sortName) throws SQLException {
        Criteria criteria = session.createCriteria(Room.class);
        if (!"zero".equals(sortName)) {
            criteria.addOrder(Order.asc(sortName));
        }
        if (empty == false) {
            criteria.add(Restrictions.eq("busy", false));
        }
        return criteria.list();
    }
}
