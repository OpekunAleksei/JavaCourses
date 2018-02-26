/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.ui.managers;

import com.senla.hotel.ui.menu.Menu;
import com.senla.hotel.ui.api.IObserver;
import com.senla.hotel.ui.utils.TextWorker;

public class Navigator implements IObserver {

    private Menu curentMenu;
    private final TextWorker textWorker;

    public Navigator(Menu curentMenu) {
        textWorker = new TextWorker();
        setCurentMenu(curentMenu);

    }

    public void printMenu() {
        for (Integer i = 0; i < this.curentMenu.getMenuItems().size(); i++) {
            textWorker.print((i).toString() + " ");
            textWorker.println(this.curentMenu.getNameMenuItem(i));
        }
    }

    public void navigate(Integer index) {

        try {
            this.curentMenu.getMenuItems().get(index).doAction();
            setCurentMenu(this.curentMenu.getMenuItems().get(index).getNextMenu());
        } catch (Exception e) {
            textWorker.setLog("Wrong mewnu item", e);

        }

    }

    public Menu getCurentMenu() {
        return curentMenu;
    }

    private void setCurentMenu(Menu curentMenu) {
        if (curentMenu != null) {
            this.curentMenu = curentMenu;
            update();
        } else {
            this.curentMenu = null;
        }

    }

    @Override
    public void update() {
        textWorker.println("You in" + curentMenu.getName());
    }
}
