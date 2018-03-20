/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.daoimpl;

import com.senla.hotel.api.dao.IGenericDao;
import com.senla.hotel.entity.AEntity;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public abstract class AbstractDao<T extends AEntity> implements IGenericDao<T> {

    private T clazz;

    public AbstractDao(T object) {
        clazz = object;
    }

    @Override
    public void delete(Session session, T object) throws SQLException {
        session.delete(object);

    }

    @Override
    public T getById(Session session, int id) throws SQLException {
        Criteria criteria = session.createCriteria(clazz.getClass()).add(Restrictions.idEq(id));
        return (T) criteria.list().get(0);
    }

    @Override
    public void create(Session session, T entity) throws SQLException {
        session.save(entity);
    }

    @Override
    public void update(Session session, T entity) throws SQLException {
        session.update(entity);
    }

    @Override
    public List<T> getAll(Session session, String sortName) throws SQLException {
        Criteria criteria = session.createCriteria(clazz.getClass());
        if ("zero".equals(sortName)) {
            return criteria.list();
        } else {
            criteria.addOrder(Order.asc(sortName));
            return criteria.list();
        }
    }
}
