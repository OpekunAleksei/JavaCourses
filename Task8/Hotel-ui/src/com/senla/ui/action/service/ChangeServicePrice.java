/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.service;

import com.senla.ui.utils.TextWorker;
import com.senla.ui.api.IAction;
import com.senla.hotel.request.Request;

public class ChangeServicePrice implements IAction {

    private TextWorker textWorker = new TextWorker();
        private final GetListOfServices getListOfServices = new GetListOfServices();
    @Override
    public void execute() {

        getListOfServices.execute();
        textWorker.println("Enter the line number where there is a service(starting from 1)");
        Integer serviceId = textWorker.getIntegerInput() - 1;
        textWorker.println("Enter new price");
        Integer price = textWorker.getIntegerInput();

        Request.getInstance().pull(textWorker.createLine("ChangeServicePrice", textWorker.createData(serviceId.toString(), price.toString())));

    }
}
