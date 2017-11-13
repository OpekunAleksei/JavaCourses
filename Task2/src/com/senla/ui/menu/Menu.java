/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.menu;

import java.util.ArrayList;

public class Menu {

    private String name;
    private ArrayList<MenuItem> menuItem;

    public Menu() {
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItem;
    }

    public void setMenuItem(ArrayList<MenuItem> menuItem) {
        this.menuItem = menuItem;
    }

    public String getNameMenuItem(Integer i) {
        return menuItem.get(i).getTitle();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
