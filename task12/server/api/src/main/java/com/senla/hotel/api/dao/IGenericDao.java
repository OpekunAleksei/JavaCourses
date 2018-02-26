/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.dao;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;

public interface IGenericDao<T> {

    public void delete(Session session  , T object) throws SQLException;

    public List<T> getAll(Session session, String sotName) throws SQLException;

    public T getById(Session session, int id) throws SQLException;

    public void update(Session session, T entity) throws SQLException;

    public void create(Session session, T entity) throws SQLException;

}
