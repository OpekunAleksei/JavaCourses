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

public class GuestManager implements IGuestManager {

    private final IGuestDao guestDao;

    public GuestManager() {
        this.guestDao = new GuestDaoImpl();

    }

    @Override
    public void setImpotrGuests(List<Guest> list) {
        guestDao.setImportGuests(list);
    }

    @Override
    public Integer getIdByNumberOnList(Integer number) {
        return guestDao.getIdByNumberOnlist(number);
    }

    @Override
    public void createGuest(String name, Date arrivalDate, Date dateOfDeparture) {

        guestDao.create(guestDao.createMiracleGuest(name, arrivalDate, dateOfDeparture));

    }

    @Override
    public Guest getGuestByID(Integer id) {
        return guestDao.getById(id);

    }

    @Override
    public List<Guest> getListOfGuest(String name) {
        return guestDao.getAll(name);
    }

 
}
