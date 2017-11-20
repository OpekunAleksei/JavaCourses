/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action;

import com.senla.ui.api.IAction;

public class Exit implements IAction {

    @Override
    public void execute() {
        System.exit(0);

    }
}
