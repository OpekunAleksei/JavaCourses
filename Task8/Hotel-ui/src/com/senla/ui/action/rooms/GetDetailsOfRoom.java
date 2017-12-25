/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.rooms;

import com.senla.ui.api.IAction;
import com.senla.hotel.request.Request;
import com.senla.ui.utils.TextWorker;

public class GetDetailsOfRoom implements IAction {
    private final GetSortRoomByCapacity getSortRoomByCapacity = new GetSortRoomByCapacity();

    private TextWorker textWorker = new TextWorker();

    @Override
    public void execute() {
      getSortRoomByCapacity.execute();
        textWorker.println("Enter the line number where there is a room(starting from 1)");
        Integer number = textWorker.getIntegerInput() - 1;

        textWorker.println(Request.getInstance().pull(textWorker.createLine("GetDetailsOfRoom", textWorker.createData(number.toString()))));

    }
}
