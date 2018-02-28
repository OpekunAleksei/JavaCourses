/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.guest;

import com.senla.ui.action.rooms.GetListOfRooms;
import com.senla.ui.api.IAction;
import com.senla.ui.utils.Request;
import com.senla.ui.utils.TextWorker;

public class SettleInRoom implements IAction {

    private final GetListOfGuests getListOfGuests = new GetListOfGuests();
    private final GetListOfRooms getListOfRooms = new GetListOfRooms();

    @Override
    public void execute() {
        getListOfGuests.execute();

        TextWorker.getInstance().println("Enter the line number where the guest(starting from 1)");
        Integer guestId = TextWorker.getInstance().getIntegerInput() - 1;
        getListOfRooms.execute();
        TextWorker.getInstance().println("Enter the line number where there is a room(starting from 1)");
        Integer numberRoom = TextWorker.getInstance().getIntegerInput() - 1;
        Request.getInstance().pull(TextWorker.getInstance().createLine("settleInRoom", TextWorker.getInstance().createData(guestId.toString(), numberRoom.toString())));

    }
}
