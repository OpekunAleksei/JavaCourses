/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.rooms;

import com.senla.hotel.enums.RoomStatus;
import com.senla.hotel.facade.HotelAdministrator;
import com.senla.ui.api.IAction;
import com.senla.ui.utils.TextWorker;

public class CopyRoom implements IAction {

    private TextWorker textWorker = new TextWorker();

    @Override
    public void execute() {
        textWorker.println(HotelAdministrator.getInstance().getSortRoomsByPrice());
        textWorker.println("Enter the line number where there is a room for copy(starting from 1)");
        Integer number = HotelAdministrator.getInstance().getRoomNumberByNumberOnList(textWorker.getIntegerInput() - 1);
        textWorker.println("Enter new number of room");
        Integer newNumber = textWorker.getIntegerInput();
        textWorker.println("Enter new id of room");
        Integer newId = textWorker.getIntegerInput();
        textWorker.setNewNumberOfRoom(newNumber);
        HotelAdministrator.getInstance().copyRoom(number, newId, newNumber);
    }
}
