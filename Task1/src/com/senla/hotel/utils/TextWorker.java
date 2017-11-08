/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.utils;

import com.senla.hotel.entity.Service;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Guest;
import java.util.ArrayList;

public class TextWorker {

    private String list;
    private StringBuilder builder = new StringBuilder();

    public TextWorker() {
        list = "";
    }

    public String getList() {
        return list;
    }

    public void CreateList(Object object) {
        builder.append(object);
        builder.append(" ");
        this.list = builder.toString();
    }

    public void addNewLine() {
        builder.append("\n");
    }

    public void CreateRoomList(ArrayList<Room> room, Integer count) {

        for (int i = 0; i < count; i++) {

            builder.append(room.get(i).getNumber());
            builder.append("\n");
        }
        this.list = builder.toString();
    }

    public void CreateServiceList(ArrayList<Service> service) {
        for (int i = 0; i < service.size(); i++) {
            builder.append(service.get(i).getCategory());
            builder.append(" ");
            builder.append(service.get(i).getPrice());
            builder.append("\n");
        }
        this.list = builder.toString();
    }

    public void CreateGuestList(ArrayList<Guest> guest) {
        for (int i = 0; i < guest.size(); i++) {
            builder.append(guest.get(i).getName());
            builder.append(" ");
            builder.append(guest.get(i).getDateOfDeparture());
            builder.append("\n");
        }
        this.list = builder.toString();
    }

}
