/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.guest;

import com.senla.hotel.enums.SortName;
import com.senla.ui.action.rooms.GetListOfRooms;
import com.senla.ui.api.IAction;
import com.senla.ui.utils.Request;
import com.senla.ui.utils.TextWorker;

public class GetSortServicesOfGuestByPrice implements IAction {

    private final GetListOfGuests getListOfGuests = new GetListOfGuests();
    private final GetListOfRooms getListOfRooms = new GetListOfRooms();

    @Override
    public void execute() {
        getListOfGuests.execute();
        TextWorker.getInstance().println("Enter the line number where the guest(starting from 1)");
        Integer id = TextWorker.getInstance().getIntegerInput() - 1;
        getListOfRooms.execute();
        TextWorker.getInstance().println("Enter the line number where there is a  room (starting from 1)");
        Integer number = TextWorker.getInstance().getIntegerInput() - 1;

        TextWorker.getInstance().println(Request.getInstance().pull(TextWorker.getInstance().createLine("getListServiceOfGuest", TextWorker.getInstance().createData(id.toString(), number.toString(), SortName.price.toString()))));

    }
}
