/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.utils;

import com.senla.hotel.entity.Service;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Guest;

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

    public void CreateList(Room[] room, Integer count) {

        for (int i = 0; i < count; i++) {

            builder.append(room[i].getNumber());
            builder.append("\n");
        }
        this.list = builder.toString();
    }

    public void CreateList(Service[] service, Integer count) {
        for (int i = 0; i < count; i++) {
            builder.append(service[i].getCategory());
            builder.append(" ");
            builder.append(service[i].getPrice());
            builder.append("\n");
        }
        this.list = builder.toString();
    }

    public void CreateList(Guest[] guest, Integer count) {
        for (int i = 0; i < count; i++) {
            builder.append(guest[i].getName());
            builder.append(" ");
            builder.append(guest[i].getDateOfDeparture());
            builder.append("\n");
        }
        this.list = builder.toString();
    }
}
