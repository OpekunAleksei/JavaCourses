/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.managers;

import com.senla.hotel.api.dao.IHistoryDao;
import com.senla.hotel.entity.Service;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Guest;
import java.util.Date;
import java.util.List;
import com.senla.hotel.api.managers.IHistoryManager;
import com.senla.hotel.daoimpl.HistoryDaoImpl;
import com.senla.hotel.entity.History;

public class HistoryManager implements IHistoryManager {

    private final IHistoryDao historyDao = new HistoryDaoImpl();

    public HistoryManager() {

    }

    @Override
    public void settleInRoom(Guest guest, Room room) {
        History history = new History();
        history.setGuest(guest);
        history.setRoom(room);
        historyDao.create(history);

    }

    @Override
    public void evictedFromRoom(Guest guest, Room room) {
        History history = new History();
        history.setGuest(guest);
        history.setRoom(room);
        historyDao.evictedFromRoom(history);

    }

    @Override
    public void addServiceToGuest(Service service, Guest guest, Room room) {
        historyDao.setService(guest, room, service);

    }

    @Override
    public Integer getGuestPriceForAccommodation(Guest guest, Room room) {

        return historyDao.getPriceForAccommodation(guest, room);
    }

    @Override
    public Integer getNumberGuestInHotel() {
        return historyDao.getNumberOfGuestInHotel();
       
    }

    @Override
    public Boolean checkForPresenceGuestsInRoom(Room room) {
        return historyDao.checForPresense(room);

    }

    @Override
    public List<Guest> getListLeftGuestThisRoom(Room room, Integer count) {
        return historyDao.getListLeftGuest(room, count);

    }

    @Override
    public List<Room> getListOfRoomsAvailableByDate(Date date, List<Room> list) {

        return historyDao.getRoomsAvalableByDate(date);

    }

    @Override
    public List<Service> getGuestServices(Guest guest, Room room, String sort) {

        return historyDao.getSortingServices(room, guest, sort);


    }

}
