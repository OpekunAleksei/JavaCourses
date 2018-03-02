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
import org.hibernate.Session;

public abstract class AbstractDao<T extends AEntity> implements IGenericDao<T> {

    protected abstract List<T> parseQueryGetById(Session session, int id) throws SQLException;

    protected abstract List<T> parseQueryGetSortingAllEntity(Session session, String condition) throws SQLException;

    protected abstract List<T> parseQueryGetAllEntity(Session session) throws SQLException;

    @Override
    public void delete(Session session, T object) throws SQLException {
        session.delete(object);

    }

    @Override
    public T getById(Session session, int id) throws SQLException {
        return parseQueryGetById(session, id).get(0);
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

        if ("zero".equals(sortName)) {
            return parseQueryGetAllEntity(session);
        } else {
            return parseQueryGetSortingAllEntity(session, sortName);

        }

    }
}
