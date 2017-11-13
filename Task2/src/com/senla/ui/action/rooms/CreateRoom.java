/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.rooms;

import com.senla.hotel.enums.RoomStatus;
import com.senla.hotel.facade.HotelAdministrator;
import com.senla.hotel.utils.Printer;
import com.senla.ui.action.OpenMenuRoom;

import com.senla.ui.api.IAction;
import com.senla.ui.utils.Helper;

public class CreateRoom implements IAction {

    private Helper helper = new Helper();
    private Printer printer = new Printer();
    private RoomStatus status;

    @Override
    public void execute() {
         printer.println("Enter number of room");
        Integer number = helper.getIntegerInput();
         printer.println("Enter price of room");
        Integer price = helper.getIntegerInput();
         printer.println("Enter capacity ");
        Integer capacity = helper.getIntegerInput();
         printer.println("Enter number of stars (1 to 5)");
        Integer numberOfStars = helper.getIntegerInput();
         printer.println("Enter id");
        Integer id = helper.getIntegerInput();
        printer.println("Enter 1 if room status repaired ,enter 2 if room status serviced");
        if (helper.getIntegerInput() == 1) {
            status = RoomStatus.repaired;
        } else {
            status = RoomStatus.serviced;
        }
       HotelAdministrator.getInstance(null, null, null).createRoom(number, price, capacity, numberOfStars, id, status);
       OpenMenuRoom openMenuRoom = new OpenMenuRoom();
        openMenuRoom.execute();
    }
}
