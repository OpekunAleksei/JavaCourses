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
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class HistoryManager implements IHistoryManager {

<<<<<<< HEAD
  
=======
    private final DbConnector dbConnector = new DbConnector();
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a
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

<<<<<<< HEAD
            DbConnector.getIstance().getConnection().setAutoCommit(false);
            roomDao.changePartOfRoom(DbConnector.getIstance().getConnection(), room.getNumber(), Boolean.TRUE, "busy");
            historyDao.create(DbConnector.getIstance().getConnection(), historyDao.getMiracleHistory(guest, room));
            DbConnector.getIstance().getConnection().commit();
=======
            dbConnector.getConnection().setAutoCommit(false);
            roomDao.changePartOfRoom(dbConnector.getConnection(), room.getNumber(), Boolean.TRUE, "busy");
            historyDao.create(dbConnector.getConnection(), historyDao.getMiracleHistory(guest, room));
            dbConnector.getConnection().commit();
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            throw new SQLException();
        }

    }

    @Override
    public void evictedFromRoom(Guest guest, Room room) throws SQLException {

        try {

<<<<<<< HEAD
            DbConnector.getIstance().getConnection().setAutoCommit(false);
            if (checkForPresenceGuestsInRoom(room) == true) {
                roomDao.changePartOfRoom(DbConnector.getIstance().getConnection(), room.getNumber(), Boolean.FALSE, "busy");
            }
            historyDao.update(DbConnector.getIstance().getConnection(), historyDao.getMiracleHistory(guest, room));
          DbConnector.getIstance().getConnection().commit();
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            DbConnector.getIstance().getConnection().rollback();
=======
            dbConnector.getConnection().setAutoCommit(false);
            if (checkForPresenceGuestsInRoom(room) == true) {
                roomDao.changePartOfRoom(dbConnector.getConnection(), room.getNumber(), Boolean.FALSE, "busy");
            }
            historyDao.update(dbConnector.getConnection(), historyDao.getMiracleHistory(guest, room));
            dbConnector.getConnection().commit();
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            dbConnector.getConnection().rollback();
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a
            throw new SQLException();
        }

    }

    @Override
    public void addServiceToGuest(Service service, Guest guest, Room room) throws SQLException {
<<<<<<< HEAD
        historyDao.setService(DbConnector.getIstance().getConnection(), guest, room, service);
=======
        historyDao.setService(dbConnector.getConnection(), guest, room, service);
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a
    }

    @Override
    public Integer getGuestPriceForAccommodation(Guest guest, Room room) throws SQLException {

<<<<<<< HEAD
        return historyDao.getPriceForAccommodation(DbConnector.getIstance().getConnection(), guest, room);
=======
        return historyDao.getPriceForAccommodation(dbConnector.getConnection(), guest, room);
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a
    }

    @Override
    public Integer getNumberGuestInHotel() throws SQLException {
<<<<<<< HEAD
        return historyDao.getNumberOfGuestInHotel(DbConnector.getIstance().getConnection());
=======
        return historyDao.getNumberOfGuestInHotel(dbConnector.getConnection());
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

    @Override
    public Boolean checkForPresenceGuestsInRoom(Room room) throws SQLException {
<<<<<<< HEAD
        return historyDao.checForPresense(DbConnector.getIstance().getConnection(), room);
=======
        return historyDao.checForPresense(dbConnector.getConnection(), room);
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

    @Override
    public List<Guest> getListLeftGuestThisRoom(Room room, Integer count) throws SQLException {
<<<<<<< HEAD
        List<Integer> listId = historyDao.getListLeftGuest(DbConnector.getIstance().getConnection(), room, count);
        List<Guest> leftGuests = new ArrayList();
        for (int i = 0; i < listId.size(); i++) {
            leftGuests.add(guestDao.getById(DbConnector.getIstance().getConnection(), listId.get(i)));
=======
        List<Integer> listId = historyDao.getListLeftGuest(dbConnector.getConnection(), room, count);
        List<Guest> leftGuests = new ArrayList();
        for (int i = 0; i < listId.size(); i++) {
            leftGuests.add(guestDao.getById(dbConnector.getConnection(), listId.get(i)));
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a
        }
        return leftGuests;

    }

    @Override
    public List<Room> getListOfRoomsAvailableByDate(Date date, List<Room> list) throws SQLException {
<<<<<<< HEAD
        List<Integer> listId = historyDao.getIdRoomsAvalableByDate(DbConnector.getIstance().getConnection(), date);
        List<Room> avaliableRooms = new ArrayList();
        for (int i = 0; i < listId.size(); i++) {
            avaliableRooms.add(roomDao.getById(DbConnector.getIstance().getConnection(), listId.get(i)));
=======
        List<Integer> listId = historyDao.getIdRoomsAvalableByDate(dbConnector.getConnection(), date);
        List<Room> avaliableRooms = new ArrayList();
        for (int i = 0; i < listId.size(); i++) {
            avaliableRooms.add(roomDao.getById(dbConnector.getConnection(), listId.get(i)));
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a
        }
        return avaliableRooms;
    }

    @Override
    public List<Service> getGuestServices(Guest guest, Room room, String sort) throws SQLException {

<<<<<<< HEAD
        return serviceDao.getById(DbConnector.getIstance().getConnection(), historyDao.getIdSortingServices(DbConnector.getIstance().getConnection(), room, guest, sort));
=======
        return serviceDao.getById(dbConnector.getConnection(), historyDao.getIdSortingServices(dbConnector.getConnection(), room, guest, sort));
>>>>>>> 0d19949fa24f2775f732adfff25b8cc4e211023a

    }

}
