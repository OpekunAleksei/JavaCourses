/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.rooms;

import com.senla.ui.api.IAction;
import com.senla.ui.utils.Request;
import com.senla.ui.utils.TextWorker;

public class GetDetailsOfRoom implements IAction {
    private final GetListOfRooms getListOfRooms = new GetListOfRooms();


    @Override
    public void execute() {
      getListOfRooms.execute();
        TextWorker.getInstance().println("Enter the line number where there is a room(starting from 1)");
        Integer number = TextWorker.getInstance().getIntegerInput() - 1;

        TextWorker.getInstance().println(Request.getInstance().pull(TextWorker.getInstance().createLine("getDetailsOfRoom", TextWorker.getInstance().createData(number.toString()))));

    }
}
