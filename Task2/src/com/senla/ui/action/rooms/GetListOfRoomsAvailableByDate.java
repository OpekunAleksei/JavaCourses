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
import com.senla.ui.utils.Helper;
import com.senla.ui.api.IAction;

public class GetListOfRoomsAvailableByDate implements IAction {

    private Helper helper = new Helper();
    private Printer printer = new Printer();
    private RoomStatus status;

    @Override
    public void execute() {
        System.out.println("enter the date(like 13/09/2017)");
        printer.println( HotelAdministrator.getInstance(null, null, null).getListOfRoomsAvailableByDate(helper.getStringInput()));
        OpenMenuRoom openMenuRoom = new OpenMenuRoom();
        openMenuRoom.execute();
    }
}
