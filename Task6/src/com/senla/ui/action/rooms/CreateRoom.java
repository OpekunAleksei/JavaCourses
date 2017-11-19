/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.rooms;

import com.senla.hotel.enums.RoomStatus;
import com.senla.hotel.facade.HotelAdministrator;
import com.senla.ui.api.IAction;
import com.senla.ui.utils.TextWorker;

public class CreateRoom implements IAction {

    private TextWorker textWorker = new TextWorker();

    private RoomStatus status;

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
            status = RoomStatus.repaired;
        } else {
            status = RoomStatus.serviced;
        }
        HotelAdministrator.getInstance().createRoom(number, price, capacity, numberOfStars, id, status);

    }
}
