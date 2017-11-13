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

public class GetSortEmptyRoomByCapacity implements IAction {

    private Helper helper = new Helper();
    private Printer printer = new Printer();
    private RoomStatus status;

    @Override
    public void execute() {
        printer.println( HotelAdministrator.getInstance(null, null, null).getSortEmptyRoomsByCapacity());
        OpenMenuRoom openMenuRoom = new OpenMenuRoom();
        openMenuRoom.execute();
    }
}
