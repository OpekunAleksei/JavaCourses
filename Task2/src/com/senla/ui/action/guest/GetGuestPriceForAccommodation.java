/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.guest;

import com.senla.hotel.facade.HotelAdministrator;
import com.senla.hotel.utils.Printer;
import com.senla.ui.action.OpenMenuGuest;

import com.senla.ui.api.IAction;
import com.senla.ui.utils.Helper;

public class GetGuestPriceForAccommodation implements IAction {

    private Helper helper = new Helper();
    private Printer printer = new Printer();

    @Override
    public void execute() {
        printer.println( HotelAdministrator.getInstance(null, null, null).getSortGuestByName());
        printer.println("Enter the line number where the guest(starting from 1)");
        printer.println( HotelAdministrator.getInstance(null, null, null).getGuestPriceForAccommodation( HotelAdministrator.getInstance(null, null, null).getGuestIdByNumberOnList(helper.getIntegerInput()-1)));
        OpenMenuGuest openMenuGuest = new OpenMenuGuest();
        openMenuGuest.execute();
    }
}
