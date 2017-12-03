/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.utils;

import com.senla.hotel.entity.Service;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Guest;
import java.util.List;

public class TextWorker {

    private  String list;
    private final StringBuilder builder = new StringBuilder();
    private final DateConverter converter = new DateConverter();

    public String CreateRoomList(List<Room> room, Integer count) {
     this.builder.setLength(0);
        Integer counter;
        if (count == null) {
            counter = room.size();
        } else {
            counter = count;
        }
        for (int i = 0; i < counter; i++) {
            builder.append(room.get(i).getNumber());
            builder.append(";");
            builder.append(room.get(i).getCapacity());
            builder.append(";");
            builder.append(room.get(i).getId());
            builder.append(";");
            builder.append(room.get(i).getNumberOfStars());
            builder.append(";");
            builder.append(room.get(i).getPrice());
            builder.append(";");
            builder.append(room.get(i).getStatus());
            builder.append("\n");
        }
        this.list = builder.toString();
        
        return  this.list;
    }

    public String CreateServiceList(List<Service> service) {

 this.builder.setLength(0);
        for (int i = 0; i < service.size(); i++) {
            builder.append(service.get(i).getId());
            builder.append(";");
            builder.append(service.get(i).getCategory());
            builder.append(";");
            builder.append(service.get(i).getPrice());

            builder.append("\n");
        }
        this.list = builder.toString();
                return this.list;
    }

    public String CreateGuestList(List<Guest> guest) {
   this.builder.setLength(0);
        for (int i = 0; i < guest.size(); i++) {
            builder.append(guest.get(i).getName());
            builder.append(";");
            builder.append(guest.get(i).getId());
            builder.append(";");
            builder.append(converter.parseDate(guest.get(i).getArrivalDate()));
            builder.append(";");
            builder.append(converter.parseDate(guest.get(i).getDateOfDeparture()));
            builder.append("\n");
        }
        this.list = builder.toString();
        return this.list;
    }

}
