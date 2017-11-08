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
import java.util.Date;

public class Hotel {

    public static void main(String[] args) throws ParseException {
        String arg[];
        arg = new String[3];
        for (int i = 0; i < args.length; ++i) {
            arg[i] = args[i];
        }

        HotelAdministrator hotelAdministrator = new HotelAdministrator(arg[0], arg[1], arg[2]);

        Date date = new Date();
        Printer printer = new Printer();
        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
        date = dateformat3.parse("23/07/1989");

        hotelAdministrator.createService();
        hotelAdministrator.createService();

        hotelAdministrator.createService();
        hotelAdministrator.createRoom();

        hotelAdministrator.createRoom();
        hotelAdministrator.createRoom();
        hotelAdministrator.createGuest();
        hotelAdministrator.createGuest();
        hotelAdministrator.createGuest();
        hotelAdministrator.createGuest();

        hotelAdministrator.settleInRoom(2, 209);
        hotelAdministrator.settleInRoom(1, 208);
        hotelAdministrator.settleInRoom(3, 209);
        hotelAdministrator.addServiceToGuest(999, 1);
        hotelAdministrator.addServiceToGuest(55000, 1);
        hotelAdministrator.addServiceToGuest(999, 1);
        hotelAdministrator.changeRoomPrice(2000, 51000);

        printer.print(hotelAdministrator.getSortEmptyRoomsByCapacity());
        printer.print(hotelAdministrator.getGuestPriceForAccommodation(1));
    }

}
