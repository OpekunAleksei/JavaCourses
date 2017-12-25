/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.rooms;

import com.senla.ui.api.IAction;
import com.senla.hotel.request.Request;
import com.senla.ui.utils.TextWorker;

public class CopyRoom implements IAction {

    private final TextWorker textWorker = new TextWorker();
    private final GetSortRoomByCapacity getSortRoomByCapacity = new GetSortRoomByCapacity();
    
    @Override
    public void execute() {
        getSortRoomByCapacity.execute();
        textWorker.println("Enter the line number where there is a room for copy(starting from 1)");
        Integer number = textWorker.getIntegerInput() - 1;
        textWorker.println("Enter new number of room");
        Integer newNumber = textWorker.getIntegerInput();
        textWorker.println("Enter new id of room");
        Integer newId = textWorker.getIntegerInput();
        textWorker.setNewNumberOfRoom(newNumber);

        Request.getInstance().pull(textWorker.createLine("CopyRoom", textWorker.createData(number.toString(), newId.toString(), newNumber.toString())));

    }
}
