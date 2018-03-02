/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.daoimpl;

import com.senla.hotel.api.dao.IGuestDao;
import com.senla.hotel.entity.Guest;
import com.senla.hotel.enums.SortName;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class GuestDaoImpl extends AbstractDao<Guest> implements IGuestDao {

    public GuestDaoImpl() {

    }

    @Override
    public Guest createMiracleGuest(String name, Date arrivalDate, Date dateOfDeparture) {
        Guest miracleGuest = new Guest(name, arrivalDate, dateOfDeparture, null);

        return miracleGuest;
    }

    @Override
    public void setImportGuests(Session session, List<Guest> list) throws SQLException {
        for (Guest list1 : list) {
            session.saveOrUpdate(list1);
        }

    }

    @Override
    public Integer getIdByNumberOnlist(Session session, Integer number) throws SQLException {
        return getAll(session, SortName.zero.toString()).get(number).getId();
    }

    @Override
    protected List<Guest> parseQueryGetById(Session session, int id) throws SQLException {
        Criteria criteria = session.createCriteria(Guest.class).add(Restrictions.idEq(id));
        return criteria.list();

    }

    @Override
    protected List<Guest> parseQueryGetSortingAllEntity(Session session, String condition) throws SQLException {
        Criteria criteria = session.createCriteria(Guest.class).addOrder(Order.asc(condition));
        return criteria.list();
    }

    @Override

    protected List<Guest> parseQueryGetAllEntity(Session session) throws SQLException {
        Criteria criteria = session.createCriteria(Guest.class);
        return criteria.list();
    }

}
