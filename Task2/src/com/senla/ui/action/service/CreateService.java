/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.service;

import com.senla.hotel.facade.HotelAdministrator;
import com.senla.hotel.utils.Printer;
import com.senla.ui.action.OpenMenuService;
import com.senla.ui.utils.Helper;
import com.senla.ui.api.IAction;

public class CreateService implements IAction {

    private Helper helper = new Helper();
    private Printer printer = new Printer();

    @Override
    public void execute() {
        System.out.println("Enter price of service");
        Integer price = helper.getIntegerInput();
        System.out.println("Enter service category");
        String category = helper.getStringInput();
        System.out.println("Enter service id");
        Integer id = helper.getIntegerInput();
       HotelAdministrator.getInstance(null, null, null).createService(id, category, id);
        OpenMenuService openMenuService = new OpenMenuService();
        openMenuService.execute();
    }
}
