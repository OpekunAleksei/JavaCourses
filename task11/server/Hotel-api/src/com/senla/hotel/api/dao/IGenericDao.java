/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IGenericDao<T> {

    public void delete(Connection connection, T object) throws SQLException;

    public List<T> getAll(Connection connection, String sotName) throws SQLException;

    public T getById(Connection connection, int id) throws SQLException;

    public void update(Connection connection, T entity) throws SQLException;

    public void create(Connection connection, T entity) throws SQLException;

}
