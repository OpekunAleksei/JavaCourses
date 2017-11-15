/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.rooms;

import com.senla.hotel.facade.HotelAdministrator;

import com.senla.ui.utils.TextWorker;
import com.senla.ui.api.IAction;

public class GetLeftThreeGuestOfRoom implements IAction {

    private TextWorker textWorker = new TextWorker();

    @Override
    public void execute() {
        textWorker.println(HotelAdministrator.getInstance().getSortRoomsByPrice());
        textWorker.println("Enter the line number where there is a service(starting from 1)");
        Integer number = HotelAdministrator.getInstance().getRoomIdByNumberOnList(textWorker.getIntegerInput() - 1);
        textWorker.println(HotelAdministrator.getInstance().getListLeftThreeGuestThisRoom(number));

    }
}
