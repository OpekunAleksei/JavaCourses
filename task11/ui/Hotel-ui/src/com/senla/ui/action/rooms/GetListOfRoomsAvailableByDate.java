/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.rooms;

import com.senla.ui.utils.TextWorker;
import com.senla.ui.api.IAction;
import com.senla.ui.utils.Request;

public class GetListOfRoomsAvailableByDate implements IAction {

 

    @Override
    public void execute() {
        TextWorker.getInstance().println("enter the date(like 13.09.2017)");

        TextWorker.getInstance().println(Request.getInstance().pull(TextWorker.getInstance().createLine("getListOfRoomsAvailableByDate", TextWorker.getInstance().createData(TextWorker.getInstance().getStringInput()))));

    }
}
