/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.ui.action.service;

import com.senla.hotel.ui.utils.TextWorker;
import com.senla.hotel.ui.api.IAction;
import com.senla.hotel.ui.utils.Request;

public class CreateService implements IAction {

    @Override
    public void execute() {
        TextWorker.getInstance().println("Enter service category");
        String category = TextWorker.getInstance().getStringInput();
        TextWorker.getInstance().println("Enter price of service");
        Integer price = TextWorker.getInstance().getIntegerInput();

        Request.getInstance().pull(TextWorker.getInstance().createLine("createService", TextWorker.getInstance().createData(price.toString(), category)));

    }
}
