/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.managers;

import com.senla.hotel.api.dao.IGuestDao;
import com.senla.hotel.api.dao.IHistoryDao;
import com.senla.hotel.api.dao.IRoomDao;
import com.senla.hotel.api.dao.IServiceDao;
import com.senla.hotel.entity.Service;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Guest;
import java.util.Date;
import java.util.List;
import com.senla.hotel.api.managers.IHistoryManager;
import com.senla.hotel.daoimpl.GuestDaoImpl;
import com.senla.hotel.daoimpl.HistoryDaoImpl;
import com.senla.hotel.daoimpl.RoomDaoImpl;
import com.senla.hotel.daoimpl.ServiceDaoImpl;

import com.senla.hotel.dbconnector.DbConnector;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class HistoryManager implements IHistoryManager {

    private final DbConnector dbConnector = new DbConnector();
    private final IServiceDao serviceDao;
    private final IGuestDao guestDao;
    private final IRoomDao roomDao;
    private final IHistoryDao historyDao;
    private static Logger logger = Logger.getLogger(HistoryManager.class);

    public HistoryManager() {
        this.roomDao = new RoomDaoImpl();
        this.serviceDao = new ServiceDaoImpl();
        this.guestDao = new GuestDaoImpl();
        this.historyDao = new HistoryDaoImpl();

    }

    @Override
    public void settleInRoom(Guest guest, Room room) throws SQLException {
        System.out.println("1");
        try {
           
            dbConnector.getConnection().setAutoCommit(false);
            roomDao.changePartOfRoom(dbConnector.getConnection(), room.getNumber(), Boolean.TRUE, "busy");
            historyDao.create(dbConnector.getConnection(), historyDao.getMiracleHistory(guest, room));
            dbConnector.getConnection().commit();

        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            throw new SQLException();
        }

    }

    @Override
    public void evictedFromRoom(Guest guest, Room room) throws SQLException {

        
        try {
            
            dbConnector.getConnection().setAutoCommit(false);
            if (checkForPresenceGuestsInRoom(room) == true) {
                roomDao.changePartOfRoom(dbConnector.getConnection(), room.getNumber(), Boolean.FALSE, "busy");
            }
            historyDao.evictedFromRoom(dbConnector.getConnection(), historyDao.getMiracleHistory(guest, room));
            dbConnector.getConnection().commit();
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            dbConnector.getConnection().rollback();
            throw new SQLException();
        }

    }

    @Override
    public void addServiceToGuest(Service service, Guest guest, Room room) throws SQLException {
        historyDao.setService(dbConnector.getConnection(), guest, room, service);
    }

    @Override
    public Integer getGuestPriceForAccommodation(Guest guest, Room room) throws SQLException {

        return historyDao.getPriceForAccommodation(dbConnector.getConnection(), guest, room);
    }

    @Override
    public Integer getNumberGuestInHotel() throws SQLException {
        return historyDao.getNumberOfGuestInHotel(dbConnector.getConnection());

    }

    @Override
    public Boolean checkForPresenceGuestsInRoom(Room room) throws SQLException {
        return historyDao.checForPresense(dbConnector.getConnection(), room);

    }

    @Override
    public List<Guest> getListLeftGuestThisRoom(Room room, Integer count) throws SQLException {
        List<Integer> listId = historyDao.getListLeftGuest(dbConnector.getConnection(), room, count);
        List<Guest> leftGuests = new ArrayList();
        for (int i = 0; i < listId.size(); i++) {
            leftGuests.add(guestDao.getById(dbConnector.getConnection(), listId.get(i)));
        }
        return leftGuests;

    }

    @Override
    public List<Room> getListOfRoomsAvailableByDate(Date date, List<Room> list) throws SQLException {
        List<Integer> listId = historyDao.getIdRoomsAvalableByDate(dbConnector.getConnection(), date);
        List<Room> avaliableRooms = new ArrayList();
        for (int i = 0; i < listId.size(); i++) {
            avaliableRooms.add(roomDao.getById(dbConnector.getConnection(), listId.get(i)));
        }
        return avaliableRooms;
    }

    @Override
    public List<Service> getGuestServices(Guest guest, Room room, String sort) throws SQLException {

        return serviceDao.getById(dbConnector.getConnection(), historyDao.getIdSortingServices(dbConnector.getConnection(), room, guest, sort));

    }

}
