/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.rooms;

import com.senla.hotel.enums.RoomStatus;
import com.senla.ui.api.IAction;
import com.senla.hotel.request.Request;
import com.senla.ui.utils.TextWorker;

public class ChangeRoomStatus implements IAction {

    private final TextWorker textWorker = new TextWorker();

    private RoomStatus status;
    private Boolean roomAbility = false;

    private final GetSortRoomByCapacity getSortRoomByCapacity = new GetSortRoomByCapacity();

    @Override
    public void execute() {

        if ("true".equals(Request.getInstance().pull("RoomAbility"))) {
            roomAbility = true;
        }
        if (roomAbility == true) {
            getSortRoomByCapacity.execute();
            textWorker.println("Enter the line number where there is a room (starting from 1)");
            Integer number = textWorker.getIntegerInput() - 1;
            textWorker.println("Enter 1 if room status repaired ,enter 2 if room status serviced");
            if (textWorker.getIntegerInput() == 1) {
                status = RoomStatus.repaired;
            } else {
                status = RoomStatus.serviced;
            }

            Request.getInstance().pull(textWorker.createLine("ChangeRoomStatus", textWorker.createData(number.toString(), status.toString())));

        } else {
            textWorker.println("Sorry function change room status is unavailable");
        }

    }
}
