/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.service;

import com.senla.ui.utils.TextWorker;
import com.senla.ui.api.IAction;
import com.senla.ui.utils.Request;

public class ChangeServicePrice implements IAction {

 
        private final GetListOfServices getListOfServices = new GetListOfServices();
    @Override
    public void execute() {

        getListOfServices.execute();
        TextWorker.getInstance().println("Enter the line number where there is a service(starting from 1)");
        Integer serviceId = TextWorker.getInstance().getIntegerInput() - 1;
        TextWorker.getInstance().println("Enter new price");
        Integer price = TextWorker.getInstance().getIntegerInput();

        Request.getInstance().pull(TextWorker.getInstance().createLine("changeServicePrice", TextWorker.getInstance().createData(serviceId.toString(), price.toString())));

    }
}
