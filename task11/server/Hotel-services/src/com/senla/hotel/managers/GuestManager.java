/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.managers;

import com.senla.hotel.api.dao.IGuestDao;
import com.senla.hotel.entity.Guest;
import java.util.Date;
import java.util.List;
import com.senla.hotel.api.managers.IGuestManager;
import com.senla.hotel.daoimpl.GuestDaoImpl;
import com.senla.hotel.dbconnector.DbConnector;
import java.sql.SQLException;

public class GuestManager implements IGuestManager {

    private final DbConnector dbConnector = new DbConnector();
    private final IGuestDao guestDao;

    public GuestManager() {
        this.guestDao = new GuestDaoImpl();

    }

    @Override
    public void setImpotrGuests(List<Guest> list) throws SQLException {
        guestDao.setImportGuests(dbConnector.getConnection(), list);
    }

    @Override
    public Integer getIdByNumberOnList(Integer number) throws SQLException {
        return guestDao.getIdByNumberOnlist(dbConnector.getConnection(), number);
    }

    @Override
    public void createGuest(String name, Date arrivalDate, Date dateOfDeparture) throws SQLException {

        guestDao.create(dbConnector.getConnection(), guestDao.createMiracleGuest(name, arrivalDate, dateOfDeparture));

    }

    @Override
    public Guest getGuestByID(Integer id) throws SQLException {

        return guestDao.getById(dbConnector.getConnection(), id);

    }

    @Override
    public List<Guest> getListOfGuest(String name) throws SQLException {
        return guestDao.getAll(dbConnector.getConnection(), name);
    }

}
