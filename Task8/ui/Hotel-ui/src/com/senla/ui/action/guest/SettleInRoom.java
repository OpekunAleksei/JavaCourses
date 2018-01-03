/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.guest;

import com.senla.ui.action.rooms.GetSortRoomByCapacity;
import com.senla.ui.api.IAction;
import com.senla.ui.utils.Request;
import com.senla.ui.utils.TextWorker;

public class SettleInRoom implements IAction {

    private final TextWorker textWorker = new TextWorker();
    private final GetSortGuestByName getSortGuestByName = new GetSortGuestByName();
    private final GetSortRoomByCapacity getSortRoomByCapacity = new GetSortRoomByCapacity();

    @Override
    public void execute() {
          getSortGuestByName.execute();
   
        textWorker.println("Enter the line number where the guest(starting from 1)");
        Integer guestId = textWorker.getIntegerInput() - 1;
 getSortRoomByCapacity.execute();
        textWorker.println("Enter the line number where there is a room(starting from 1)");
        Integer numberRoom = textWorker.getIntegerInput() - 1;
        Request.getInstance().pull(textWorker.createLine("settleInRoom", textWorker.createData(guestId.toString(), numberRoom.toString())));

    }
}
