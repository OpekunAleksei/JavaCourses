/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.rooms;

import com.senla.hotel.facade.HotelAdministrator;
import com.senla.hotel.utils.Printer;
import com.senla.ui.action.OpenMenuRoom;

import com.senla.ui.api.IAction;
import com.senla.ui.utils.Helper;

public class ChangeRoomPrice implements IAction {

    private Helper helper = new Helper();
    private Printer printer = new Printer();

    @Override
    public void execute() {
        printer.println( HotelAdministrator.getInstance(null, null, null).getSortRoomsByPrice());
        printer.println("Enter the line number where there is a service(starting from 1)");
        Integer number =  HotelAdministrator.getInstance(null, null, null).getRoomIdByNumberOnList(helper.getIntegerInput() - 1);
        printer.println("Enter new price");
        Integer price =  HotelAdministrator.getInstance(null, null, null).getRoomIdByNumberOnList(helper.getIntegerInput() - 1);
        HotelAdministrator.getInstance(null, null, null).changeRoomPrice(number, price);
        OpenMenuRoom openMenuRoom = new OpenMenuRoom();
        openMenuRoom.execute();
    }
}
