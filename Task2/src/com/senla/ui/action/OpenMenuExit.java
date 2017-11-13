/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action;

import com.senla.hotel.facade.HotelAdministrator;
import com.senla.ui.api.IAction;

public class OpenMenuExit implements IAction {

    @Override
    public void execute() {

       HotelAdministrator.getInstance(null, null, null).writeToGuestFile();
       HotelAdministrator.getInstance(null, null, null).writeToRoomFile();
        HotelAdministrator.getInstance(null, null, null).writeToServiceFile();
        System.exit(0);

    }
}
