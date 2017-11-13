/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.guest;

import com.senla.hotel.facade.HotelAdministrator;
import com.senla.hotel.utils.Printer;
import com.senla.ui.action.OpenMenuGuest;
import com.senla.ui.utils.Helper;
import com.senla.ui.api.IAction;


public class AddService implements IAction {

    private Helper helper = new Helper();
    private Printer printer = new Printer();

    @Override
    public void execute() {
        printer.println( HotelAdministrator.getInstance(null, null, null).getSortGuestByName());
        printer.println("Enter the line number where the guest(starting from 1)");
        Integer guestId =  HotelAdministrator.getInstance(null, null, null).getGuestIdByNumberOnList(helper.getIntegerInput()-1);
        printer.println( HotelAdministrator.getInstance(null, null, null).getListOfServices());
        printer.println("Enter the line number where there is a service(starting from 1)");
        Integer serviceId =  HotelAdministrator.getInstance(null, null, null).getServiceIdByNumberOnList(helper.getIntegerInput()-1);

         HotelAdministrator.getInstance(null, null, null).addServiceToGuest(serviceId, guestId);

        OpenMenuGuest openMenuGuest = new OpenMenuGuest();
        openMenuGuest.execute();
    }

}
