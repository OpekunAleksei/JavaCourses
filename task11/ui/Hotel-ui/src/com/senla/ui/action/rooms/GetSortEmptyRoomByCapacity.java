/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.rooms;

import com.senla.hotel.enums.SortName;
import com.senla.ui.utils.TextWorker;
import com.senla.ui.api.IAction;
import com.senla.ui.utils.Request;

public class GetSortEmptyRoomByCapacity implements IAction {

 

    @Override
    public void execute() {

         TextWorker.getInstance().println(Request.getInstance().pull(TextWorker.getInstance().createLine("getListOfRooms", TextWorker.getInstance().createData(SortName.capacity.toString(),Boolean.FALSE.toString()))));

    }
}
