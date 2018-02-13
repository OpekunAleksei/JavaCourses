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


    @Override
    public void execute() {
        TextWorker.getInstance().println("Enter name");
        String name = TextWorker.getInstance().getStringInput();
        TextWorker.getInstance().println("Enter arrival date like 13.13.1666");
        String arrivalDate = TextWorker.getInstance().getStringInput();
        TextWorker.getInstance().println("Enter date of departure like 13.13.1666");
        String dateOfDeparture = TextWorker.getInstance().getStringInput();
           Request.getInstance().pull(TextWorker.getInstance().createLine("createGuest", TextWorker.getInstance().createData(name, arrivalDate, dateOfDeparture)));

    }

}
