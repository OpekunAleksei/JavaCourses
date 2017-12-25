/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.service;

import com.senla.ui.utils.TextWorker;
import com.senla.ui.api.IAction;
import com.senla.hotel.request.Request;

public class CreateService implements IAction {

    private TextWorker textWorker = new TextWorker();

    @Override
    public void execute() {
        textWorker.println("Enter service category");
        String category = textWorker.getStringInput();
        textWorker.println("Enter price of service");
        Integer price = textWorker.getIntegerInput();
        textWorker.println("Enter service id");
        Integer id = textWorker.getIntegerInput();

        Request.getInstance().pull(textWorker.createLine("CreateService", textWorker.createData(price.toString(), category, id.toString())));

    }
}
