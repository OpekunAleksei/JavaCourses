/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.rooms;

import com.senla.ui.api.IAction;
import com.senla.ui.utils.Request;
import com.senla.ui.utils.TextWorker;

public class ChangeNumberOfStars implements IAction {



    @Override
    public void execute() {
        TextWorker.getInstance().println("Enter new number of stars");
        Integer numberOfStars = TextWorker.getInstance().getIntegerInput();
        Request.getInstance().pull(TextWorker.getInstance().createLine("changeNumberOfStars", TextWorker.getInstance().createData(TextWorker.getInstance().getNewNumberOfRoom().toString(), numberOfStars.toString())));

    }
}
