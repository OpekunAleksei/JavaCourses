/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.runner;

import com.senla.ui.facade.MenuController;

import java.text.ParseException;

public class Runner {

    public static void main(String[] args) throws ParseException {

        MenuController menuController = new MenuController();
        menuController.run();

    }

}
