/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.daoimpl;

import com.senla.hotel.api.dao.IGenericDao;
import com.senla.hotel.entity.Entity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
<<<<<<< HEAD

public abstract class AbstractDao<T extends Entity> implements IGenericDao<T> {

=======
import org.apache.log4j.Logger;

public abstract class AbstractDao<T extends Entity> implements IGenericDao<T> {

    private static final Logger logger = Logger.getLogger(AbstractDao.class);
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    protected abstract String getByIdQuery();

    protected abstract String getUpdateQuery();

    protected abstract String getCreateQuery();

    protected abstract String getAllQuery();

    protected abstract String getDeleteQuery();

    protected abstract String getSortingAllQuery();

    protected abstract List<T> parseQueryGetById(PreparedStatement ps, int id) throws SQLException;

    protected abstract void parseQueryCreateEntity(PreparedStatement ps, T object) throws SQLException;

    protected abstract List<T> parseQueryGetSortingAllEntity(PreparedStatement ps, String condition) throws SQLException;

    protected abstract List<T> parseQueryGetAllEntity(PreparedStatement ps) throws SQLException;

    protected abstract void parseQueryDeleteEntity(PreparedStatement ps, T object) throws SQLException;

    protected abstract void parseQueryUpdateEntity(PreparedStatement ps, T object) throws SQLException;

    @Override
    public void delete(Connection connection, T object) throws SQLException {
        String query = getDeleteQuery();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            parseQueryDeleteEntity(ps, object);
            ps.executeUpdate();
        }
    }

    @Override
    public T getById(Connection connection, int id) throws SQLException {
        String query = getByIdQuery();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            return parseQueryGetById(ps, id).get(0);
        }
    }

    @Override
    public void create(Connection connection, T entity) throws SQLException {
        String query = getCreateQuery();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            parseQueryCreateEntity(ps, entity);
            ps.executeUpdate();
        }
    }

    @Override
    public void update(Connection connection, T entity) throws SQLException {
        String query = getUpdateQuery();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            parseQueryUpdateEntity(ps, entity);
            ps.executeUpdate();
        }
    }

    @Override
    public List<T> getAll(Connection connection, String sortName) throws SQLException {
        Boolean sort = Boolean.FALSE;
        String query;
        if ("zero".equals(sortName)) {
            query = getAllQuery();
        } else {
            sort = Boolean.TRUE;
            query = getSortingAllQuery();
        }
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            if (sort == true) {
                return parseQueryGetSortingAllEntity(ps, sortName);
            } else {
                return parseQueryGetAllEntity(ps);
            }
        }
    }

}
