/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.guest;

import com.senla.hotel.facade.HotelAdministrator;
import com.senla.hotel.utils.Printer;
import com.senla.ui.action.OpenMenuGuest;
import java.text.ParseException;
import com.senla.ui.api.IAction;
import com.senla.ui.utils.Helper;

public class CreateGuest implements IAction {

    private Helper helper = new Helper();
    private Printer printer = new Printer();

    @Override
    public void execute() {
        try {
            System.out.println("Enter name");
            String name = helper.getStringInput();
            System.out.println("Enter arrival date like 13/13/1666");
            String arrivalDate = helper.getStringInput();
            System.out.println("Enter date of departure like 13/13/1666");
            String dateOfDeparture = helper.getStringInput();
            System.out.println("Enter id");
            Integer id = helper.getIntegerInput();

            HotelAdministrator.getInstance(null, null, null).createGuest(name, arrivalDate, dateOfDeparture, id);
        } catch (ParseException ex) {
        }
        OpenMenuGuest openMenuGuest = new OpenMenuGuest();
        openMenuGuest.execute();
    }

}
