/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.managers;

import com.senla.ui.menu.Menu;
import com.senla.hotel.utils.Printer;

public class Navigator {

    private Menu curentMenu;
    private Printer printer;


    public Navigator() {
        curentMenu = new Menu();
        printer = new Printer();
    }

    public void printMenu() {
        for (Integer i = 0; i < this.curentMenu.getMenuItems().size(); i++) {
            printer.print((i).toString() + " ");
            printer.println(this.curentMenu.getNameMenuItem(i));
        }
    }

    public void navigate(Integer index) {

        this.curentMenu.getMenuItems().get(index).doAction();

    }

    public Menu getCurentMenu() {
        return curentMenu;
    }

    public void setCurentMenu(Menu curentMenu) {
        this.curentMenu = curentMenu;
    }

}
