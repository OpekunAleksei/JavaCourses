/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.ui.action.rooms;

import com.senla.hotel.ui.api.IAction;
import com.senla.hotel.ui.utils.Request;
import com.senla.hotel.ui.utils.TextWorker;

public class ChangeRoomStatus implements IAction {

    private String status;
    private Boolean roomAbility = false;

    private final GetListOfRooms getListOfRooms = new GetListOfRooms();

    @Override
    public void execute() {

        if ("true".equals(Request.getInstance().pull("getRoomAbility"))) {
            roomAbility = true;
        }
        if (roomAbility == true) {
            getListOfRooms.execute();
            TextWorker.getInstance().println("Enter the line number where there is a room (starting from 1)");
            Integer number = TextWorker.getInstance().getIntegerInput() - 1;
            TextWorker.getInstance().println("Enter 1 if room status repaired ,enter 2 if room status serviced");
            if (TextWorker.getInstance().getIntegerInput() == 1) {
                status = "repaired";
            } else {
                status = "serviced";
            }

            Request.getInstance().pull(TextWorker.getInstance().createLine("changeRoomStatus", TextWorker.getInstance().createData(number.toString(), status)));

        } else {
            TextWorker.getInstance().println("Sorry function change room status is unavailable");
        }

    }
}
