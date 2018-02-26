/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.ui.action.rooms;

import com.senla.hotel.ui.api.IAction;
import com.senla.hotel.ui.utils.Request;
import com.senla.hotel.ui.utils.TextWorker;

public class CreateRoom implements IAction {

    private String status;

    @Override
    public void execute() {
        TextWorker.getInstance().println("Enter number of room");
        Integer number = TextWorker.getInstance().getIntegerInput();
        TextWorker.getInstance().println("Enter price of room");
        Integer price = TextWorker.getInstance().getIntegerInput();
        TextWorker.getInstance().println("Enter capacity ");
        Integer capacity = TextWorker.getInstance().getIntegerInput();
        TextWorker.getInstance().println("Enter number of stars (1 to 5)");
        Integer numberOfStars = TextWorker.getInstance().getIntegerInput();
        TextWorker.getInstance().println("Enter 1 if room status repaired ,enter 2 if room status serviced");
        if (TextWorker.getInstance().getIntegerInput() == 1) {
            status = "repaired";
        } else {
            status = "serviced";
        }

        Request.getInstance().pull(TextWorker.getInstance().createLine("createRoom", TextWorker.getInstance().createData(number.toString(), price.toString(), capacity.toString(), numberOfStars.toString(), status)));

    }
}
