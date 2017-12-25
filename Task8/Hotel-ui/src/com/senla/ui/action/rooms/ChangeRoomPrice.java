/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.rooms;

import com.senla.ui.api.IAction;
import com.senla.hotel.request.Request;
import com.senla.ui.utils.TextWorker;

public class ChangeRoomPrice implements IAction {

    private final TextWorker textWorker = new TextWorker();
    private final GetSortRoomByCapacity getSortRoomByCapacity = new GetSortRoomByCapacity();

    @Override
    public void execute() {
         getSortRoomByCapacity.execute();
        textWorker.println("Enter the line number where there is a  room (starting from 1)");
        Integer number = textWorker.getIntegerInput() - 1;
        textWorker.println("Enter new price");
        Integer price = textWorker.getIntegerInput();

        Request.getInstance().pull(textWorker.createLine("ChangeRoomPrice", textWorker.createData(number.toString(), price.toString())));

    }
}
