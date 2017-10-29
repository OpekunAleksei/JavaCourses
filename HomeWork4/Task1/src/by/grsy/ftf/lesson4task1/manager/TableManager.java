/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grsy.ftf.lesson4task1.manager;

import by.grsy.ftf.lesson4task1.entity.Guest;
import by.grsy.ftf.lesson4task1.entity.Room;
import by.grsy.ftf.lesson4task1.entity.Service;
import by.grsy.ftf.lesson4task1.comparator.ServiceComparator;
import by.grsy.ftf.lesson4task1.storage.TableStorage;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

public class TableManager {

    private TableStorage tableStorage;

    public TableManager() {
        tableStorage = new TableStorage();
    }
    public void entryGuestToTable(Guest guest, Room room) throws ParseException {
        tableStorage.setGuestInTable(guest, room);
    }

    public void addServiceToGuest(Service service, Guest guest) {
        tableStorage.addServiceToGuest(service, guest);
    }

    public void entryRoomToTable(Room room) {
        tableStorage.setRoomInTable(room);
    }

    public Integer getNumberEmptyRoomInHotel() {
        return tableStorage.getNumberEmptyRoomInHotel();
    }

    public String getGuestSortServiceByPrice(Guest guest) {
        Arrays.sort(tableStorage.getArrayGuestService(guest), new ServiceComparator().getServiceByPriceComparator());
        return tableStorage.getGuestListOfService(guest);
    }

    public String getSortListServiceGuestByCategory(Guest guest) {
        Arrays.sort(tableStorage.getArrayGuestService(guest), new ServiceComparator().getServiceByCategoryComparator());
        return tableStorage.getGuestListOfService(guest);
    }

    public Room getRoom(Guest guest) {
        return tableStorage.getRoomInTable(guest);
    }

    public void evictedFromRoom(Guest guest) throws ParseException {
        tableStorage.evictedFromRoom(guest);
    }

    public Integer getNumberGuestInHotel() {
        return tableStorage.getNumberGuestInHotel();
    }

    public String getListLeftGuestThisRoom(Room room) {
        return tableStorage.getListLeftGuestThisRoom(room);
    }

    public String getListOfRoomsAvailableByDate(Date date) {
        return tableStorage.getListOfRoomsAvailableByDate(date);
    }

    public Integer getGuestPriceForAccommodation(Room room) {
        return tableStorage.getGuestPriceForAccommodation(room);
    }
}
