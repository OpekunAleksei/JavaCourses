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

public class ChangeRoomStatus implements IAction {

    private TextWorker textWorker = new TextWorker();

    private RoomStatus status;

    @Override
    public void execute() {
        textWorker.println(HotelAdministrator.getInstance().getSortRoomsByPrice());
        textWorker.println("Enter the line number where there is a service(starting from 1)");
        Integer number = HotelAdministrator.getInstance().getRoomIdByNumberOnList(textWorker.getIntegerInput() - 1);
        textWorker.println("Enter 1 if room status repaired ,enter 2 if room status serviced");
        if (textWorker.getIntegerInput() == 1) {
            status = RoomStatus.repaired;
        } else {
            status = RoomStatus.serviced;
        }
        HotelAdministrator.getInstance().changeRoomStatus(number, status);

    }
}
