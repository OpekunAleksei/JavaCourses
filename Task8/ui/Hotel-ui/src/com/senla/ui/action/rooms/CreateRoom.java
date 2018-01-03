/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.rooms;

import com.senla.ui.api.IAction;
import com.senla.ui.utils.Request;
import com.senla.ui.utils.TextWorker;

public class CreateRoom implements IAction {

    private TextWorker textWorker = new TextWorker();

    private String status;

    @Override
    public void execute() {
        textWorker.println("Enter number of room");
        Integer number = textWorker.getIntegerInput();
        textWorker.println("Enter price of room");
        Integer price = textWorker.getIntegerInput();
        textWorker.println("Enter capacity ");
        Integer capacity = textWorker.getIntegerInput();
        textWorker.println("Enter number of stars (1 to 5)");
        Integer numberOfStars = textWorker.getIntegerInput();
        textWorker.println("Enter id");
        Integer id = textWorker.getIntegerInput();
        textWorker.println("Enter 1 if room status repaired ,enter 2 if room status serviced");
        if (textWorker.getIntegerInput() == 1) {
            status = "repaired";
        } else {
            status = "serviced";
        }

        Request.getInstance().pull(textWorker.createLine("createRoom", textWorker.createData(number.toString(), price.toString(), capacity.toString(), numberOfStars.toString(), id.toString(), status)));

    }
}
