/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.facade;

import com.senla.ui.utils.Helper;

public class MenuController {

    private Helper administrator = new Helper();

    public void run() {
        administrator.getBuilder().buildMainMenu();
        administrator.getNavigator().setCurentMenu(administrator.getBuilder().getRootMenu());
        administrator.getNavigator().printMenu();
        administrator.getNavigator().navigate(administrator.getIntegerInput());
    }
}
