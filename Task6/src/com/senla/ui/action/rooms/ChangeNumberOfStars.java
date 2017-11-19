/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.rooms;

import com.senla.hotel.facade.HotelAdministrator;
import com.senla.ui.api.IAction;
import com.senla.ui.utils.TextWorker;

public class ChangeNumberOfStars implements IAction{
    private TextWorker textWorker = new TextWorker();



    @Override
    public void execute() {
        textWorker.println("Enter new number of stars");
        Integer numberOfStars =textWorker.getIntegerInput();
        HotelAdministrator.getInstance().changeNumberOfStars(textWorker.getNewNumberOfRoom(), numberOfStars);

    }
}