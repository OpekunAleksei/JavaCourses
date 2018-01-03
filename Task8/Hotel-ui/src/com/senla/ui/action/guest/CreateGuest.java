/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.guest;

import com.senla.ui.api.IAction;
import com.senla.ui.utils.Request;
import com.senla.ui.utils.TextWorker;

public class CreateGuest implements IAction {

    private final TextWorker textWorker = new TextWorker();

    @Override
    public void execute() {
        textWorker.println("Enter name");
        String name = textWorker.getStringInput();
        textWorker.println("Enter arrival date like 13.13.1666");
        String arrivalDate = textWorker.getStringInput();
        textWorker.println("Enter date of departure like 13.13.1666");
        String dateOfDeparture = textWorker.getStringInput();
        textWorker.println("Enter id");
        Integer id = textWorker.getIntegerInput();
           Request.getInstance().pull(textWorker.createLine("createGuest", textWorker.createData(name, arrivalDate, dateOfDeparture, id.toString())));

    }

}
