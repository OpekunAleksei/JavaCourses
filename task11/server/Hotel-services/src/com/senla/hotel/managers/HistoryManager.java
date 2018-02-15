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
import com.senla.hotel.api.managers.IRoomManager;
import com.senla.hotel.daoimpl.GuestDaoImpl;
import com.senla.hotel.daoimpl.HistoryDaoImpl;
import com.senla.hotel.daoimpl.RoomDaoImpl;
import com.senla.hotel.daoimpl.ServiceDaoImpl;
import com.senla.hotel.dbconnection.DbConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.logging.Level;
import org.apache.log4j.Logger;

public class HistoryManager implements IHistoryManager {

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
    public void settleInRoom(Guest guest, Room room, IRoomManager roomManager) throws SQLException {
        Connection connection = null;
        Savepoint savepointOne = null;
        try {

            connection = DbConnection.getInstance().getConnection();
            savepointOne = connection.setSavepoint("SavepointOne");
            connection.setAutoCommit(false);
            roomManager.changeRoomBusy(room.getNumber(), Boolean.TRUE);
            historyDao.create(historyDao.getMiracleHistory(guest, room));
            connection.commit();

        } catch (SQLException ex) {

            logger.error(new Date() + " " + ex.getMessage());
            connection.rollback(savepointOne);

        } finally {
            connection.close();
        }

    }

    @Override
    public void evictedFromRoom(Guest guest, Room room, IRoomManager roomManager) throws SQLException {
        Connection connection = null;
        Savepoint savepointOne = null;
        try {

            connection = DbConnection.getInstance().getConnection();
            savepointOne = connection.setSavepoint("SavepointOne");
            connection.setAutoCommit(false);
            if (checkForPresenceGuestsInRoom(room) == true) {
                roomManager.changeRoomBusy((room.getNumber()), Boolean.FALSE);
            }
            historyDao.evictedFromRoom(historyDao.getMiracleHistory(guest, room));
            connection.commit();
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            connection.rollback(savepointOne);
        } finally {
            connection.close();
        }

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
        return guestDao.getById(historyDao.getListLeftGuest(room, count));

    }

    @Override
    public List<Room> getListOfRoomsAvailableByDate(Date date, List<Room> list) {

        return roomDao.getById(historyDao.getIdRoomsAvalableByDate(date));

    }

    @Override
    public List<Service> getGuestServices(Guest guest, Room room, String sort) {

        return serviceDao.getById(historyDao.getIdSortingServices(room, guest, sort));

    }

}
