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

    public IGuestDao guestDao = new GuestDaoImpl();

    public GuestManager() {

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

        Guest guest = new Guest(name, arrivalDate, dateOfDeparture, null);
        guestDao.create(guest);

    }

    @Override
    public Guest getGuestByID(Integer id) {
        return guestDao.getByID(id);

    }

    @Override
    public List<Guest> sorting(String name) {

        return guestDao.getSortingList(name);
    }

    @Override
    public List<Guest> getGuests() {
        return guestDao.getAll();
    }
}
