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

<<<<<<< HEAD

=======
    private final DbConnector dbConnector = new DbConnector();
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a
    private final IGuestDao guestDao;

    public GuestManager() {
        this.guestDao = new GuestDaoImpl();

    }

    @Override
    public void setImpotrGuests(List<Guest> list) throws SQLException {
<<<<<<< HEAD
        guestDao.setImportGuests(DbConnector.getIstance().getConnection(), list);
=======
        guestDao.setImportGuests(dbConnector.getConnection(), list);
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a
    }

    @Override
    public Integer getIdByNumberOnList(Integer number) throws SQLException {
<<<<<<< HEAD
        return guestDao.getIdByNumberOnlist(DbConnector.getIstance().getConnection(), number);
=======
        return guestDao.getIdByNumberOnlist(dbConnector.getConnection(), number);
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a
    }

    @Override
    public void createGuest(String name, Date arrivalDate, Date dateOfDeparture) throws SQLException {

<<<<<<< HEAD
        guestDao.create(DbConnector.getIstance().getConnection(), guestDao.createMiracleGuest(name, arrivalDate, dateOfDeparture));
=======
        guestDao.create(dbConnector.getConnection(), guestDao.createMiracleGuest(name, arrivalDate, dateOfDeparture));
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

    @Override
    public Guest getGuestByID(Integer id) throws SQLException {

<<<<<<< HEAD
        return guestDao.getById(DbConnector.getIstance().getConnection(), id);
=======
        return guestDao.getById(dbConnector.getConnection(), id);
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

    @Override
    public List<Guest> getListOfGuest(String name) throws SQLException {
<<<<<<< HEAD
        return guestDao.getAll(DbConnector.getIstance().getConnection(), name);
=======
        return guestDao.getAll(dbConnector.getConnection(), name);
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a
    }

}
