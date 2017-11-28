/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.utils;

import com.senla.hotel.entity.Guest;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;
import java.util.List;
import java.util.Objects;

public class ListRefresher {

    public List refreshGuest(Guest guest, List<Guest> guestList) {
        if (guestList.isEmpty()) {
            guestList.add(guest);
            return guestList;

        } else {
            for (int i = 0; i < guestList.size(); i++) {
                if (!Objects.equals(guestList.get(i).getId(), guest.getId())) {

                    if (i == guestList.size() - 1) {
                        guestList.add(guest);
                    }
                } else {
                    guestList.remove(i);
                    guestList.add(guest);
                    return guestList;
                }
            }
        }
        return guestList;
    }

    public List refreshRoom(Room room, List<Room> roomList) {
        if (roomList.isEmpty()) {
            roomList.add(room);
            return roomList;

        } else {
            for (int i = 0; i < roomList.size(); i++) {

                if (!Objects.equals(roomList.get(i).getId(), room.getId())) {
                    if (i == roomList.size() - 1) {
                        roomList.add(room);
                    }

                } else {
                    roomList.remove(i);
                    roomList.add(room);
                    return roomList;
                }
            }
        }
        return roomList;
    }

    public List refreshService(Service service, List<Service> serviceList) {
        if (serviceList.isEmpty()) {
            serviceList.add(service);
            return serviceList;
        } else {
            for (int i = 0; i < serviceList.size(); i++) {

                if (!Objects.equals(serviceList.get(i).getId(), service.getId())) {
                    if (i == serviceList.size() - 1) {
                        serviceList.add(service);
                    }

                } else {
                    serviceList.remove(i);
                    serviceList.add(service);
                    return serviceList;
                }
            }
        }
        return serviceList;
    }

}
