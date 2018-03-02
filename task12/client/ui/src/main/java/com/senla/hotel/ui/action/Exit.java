package com.senla.hotel.ui.action;

import com.senla.hotel.ui.api.IAction;
import com.senla.hotel.ui.utils.Request;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Exit implements IAction {

    @Override
    public void execute() {

        Request.getInstance().pull("writeData");
        Request.getInstance().closeConnection();
    }
}
