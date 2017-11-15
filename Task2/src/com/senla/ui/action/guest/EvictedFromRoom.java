/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.guest;

import com.senla.hotel.facade.HotelAdministrator;

import com.senla.ui.api.IAction;
import com.senla.ui.utils.TextWorker;

public class EvictedFromRoom implements IAction {

    private TextWorker textWorker = new TextWorker();

    @Override
    public void execute() {
        textWorker.println(HotelAdministrator.getInstance().getSortGuestByName());
        textWorker.println("Enter the line number where the guest(starting from 1)");
        Integer guestId = HotelAdministrator.getInstance().getGuestIdByNumberOnList(textWorker.getIntegerInput() - 1);
        textWorker.println(HotelAdministrator.getInstance().getSortRoomsByPrice());
        textWorker.println("Enter the line number where there is a room(starting from 1)");
        Integer numberRoom = HotelAdministrator.getInstance().getRoomIdByNumberOnList(textWorker.getIntegerInput() - 1);

        HotelAdministrator.getInstance().evictedFromRoom(guestId, numberRoom);

    }
}
