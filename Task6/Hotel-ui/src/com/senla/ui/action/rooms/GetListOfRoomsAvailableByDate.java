/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.rooms;

import com.senla.hotel.facade.HotelAdministrator;
import com.senla.ui.utils.TextWorker;
import com.senla.ui.api.IAction;

public class GetListOfRoomsAvailableByDate implements IAction {

    private TextWorker textWorker = new TextWorker();

    @Override
    public void execute() {
        textWorker.println("enter the date(like 13/09/2017)");
        textWorker.println(HotelAdministrator.getInstance().getListOfRoomsAvailableByDate(textWorker.getStringInput()));

    }
}
