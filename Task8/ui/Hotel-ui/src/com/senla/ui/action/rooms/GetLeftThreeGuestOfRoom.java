/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.rooms;

import com.senla.ui.utils.TextWorker;
import com.senla.ui.api.IAction;
import com.senla.ui.utils.Request;

public class GetLeftThreeGuestOfRoom implements IAction {
 
    private TextWorker textWorker = new TextWorker();
    private final GetSortRoomByCapacity getSortRoomByCapacity = new GetSortRoomByCapacity();

    @Override
    public void execute() {
      getSortRoomByCapacity.execute();
        textWorker.println("Enter the line number where there is a room(starting from 1)");
        Integer number = textWorker.getIntegerInput() - 1;

        textWorker.println(Request.getInstance().pull(textWorker.createLine("getListLeftGuestThisRoom", textWorker.createData(number.toString()))));

    }
}
