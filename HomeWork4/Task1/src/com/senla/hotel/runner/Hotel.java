/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.runner;

import com.senla.hotel.facade.HotelAdministrator;
import com.senla.hotel.utils.Printer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Hotel {

    public static void main(String[] args) throws ParseException {
        String arg[];
        arg = new String[3];
        for (int i = 0; i < args.length; ++i) {
            arg[i] = args[i];
        }
        //   String array[];
        // array = new String[4];
        //HotelAdministrator hotelAdministrator =new HotelAdministrator() ;
        //array[0]="209;5;7;1;3;repaired;";
       // array[1]="209;5;7;1;3;repaired;";
       // array[2]="209;5;7;1;3;repaired;";
       // array[3]="209;5;7;1;3;repaired;";
       // hotelAdministrator.writeToRoomFile(arg[0], barg);
       HotelAdministrator hotelAdministrator = new HotelAdministrator(arg[0], arg[1], arg[2]);
        Date date = new Date();
                Printer printer = new Printer();
        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
        date = dateformat3.parse("23/07/1989");
        hotelAdministrator.createService();
        hotelAdministrator.createService();
        hotelAdministrator.createRoom();
        hotelAdministrator.createRoom();
        hotelAdministrator.createRoom();
        hotelAdministrator.createGuest();
        hotelAdministrator.createGuest();
        hotelAdministrator.createGuest();
        hotelAdministrator.createGuest();
        hotelAdministrator.settleInRoom(3, 209);
        hotelAdministrator.settleInRoom(1, 208);
        hotelAdministrator.settleInRoom(2, 208);
        hotelAdministrator.addServiceToGuest(999, 3);
        hotelAdministrator.evictedFromRoom(1, 208);
        hotelAdministrator.evictedFromRoom(2, 208);
printer.print(hotelAdministrator.getSortEmptyRoomsByCapacity());
 

    }

}
