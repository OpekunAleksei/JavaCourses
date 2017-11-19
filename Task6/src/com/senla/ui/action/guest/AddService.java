/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.guest;

import com.senla.hotel.facade.HotelAdministrator;

import com.senla.ui.utils.TextWorker;
import com.senla.ui.api.IAction;

public class AddService implements IAction {

    private TextWorker textWorker = new TextWorker();

    @Override
    public void execute() {
        textWorker.println(HotelAdministrator.getInstance().getSortGuestByName());
        textWorker.println("Enter the line number where the guest(starting from 1)");
        Integer guestId = HotelAdministrator.getInstance().getGuestIdByNumberOnList(textWorker.getIntegerInput() - 1);
        textWorker.println(HotelAdministrator.getInstance().getListOfServices());
        textWorker.println("Enter the line number where there is a service(starting from 1)");
        Integer serviceId = HotelAdministrator.getInstance().getServiceIdByNumberOnList(textWorker.getIntegerInput() - 1);

        HotelAdministrator.getInstance().addServiceToGuest(serviceId, guestId);

    }

}
