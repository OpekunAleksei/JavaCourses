/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action;

import com.senla.ui.utils.Helper;
import com.senla.ui.api.IAction;


public class OpenMenuService implements IAction {

    private Helper helper = new Helper();

    public OpenMenuService() {
        helper.getBuilder().buildServiceMenu();
    }

    @Override
    public void execute() {

        helper.getNavigator().setCurentMenu(helper.getBuilder().getRootMenu());
        helper.getNavigator().printMenu();
        helper.getNavigator().navigate(helper.getIntegerInput());
    }

}
