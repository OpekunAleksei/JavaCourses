/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.managers;

import com.senla.ui.menu.Menu;
import com.senla.ui.api.IObserver;
import com.senla.ui.utils.TextWorker;

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
        this.curentMenu = curentMenu;
        update();
    }

    @Override
    public void update() {
        textWorker.println("You in" + curentMenu.getName());
    }
}
