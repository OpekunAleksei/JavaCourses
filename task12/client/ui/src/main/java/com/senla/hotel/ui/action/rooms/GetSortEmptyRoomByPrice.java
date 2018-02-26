/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.ui.action.rooms;

import com.senla.hotel.enums.SortName;
import com.senla.hotel.ui.utils.TextWorker;
import com.senla.hotel.ui.api.IAction;
import com.senla.hotel.ui.utils.Request;

public class GetSortEmptyRoomByPrice implements IAction {

    @Override
    public void execute() {

        TextWorker.getInstance().println(Request.getInstance().pull(TextWorker.getInstance().createLine("getListOfRooms", TextWorker.getInstance().createData(SortName.price.toString(), Boolean.FALSE.toString()))));

    }
}
