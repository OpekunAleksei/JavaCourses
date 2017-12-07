package com.senla.ui.action.guest;

import com.senla.hotel.facade.HotelAdministrator;

import com.senla.ui.api.IAction;
import com.senla.ui.utils.TextWorker;

public class GetSortServisecOfGuestByCategory implements IAction {

    private final TextWorker textWorker = new TextWorker();

    @Override
    public void execute() {
        textWorker.println(HotelAdministrator.getInstance().getSortGuestByName());
        textWorker.println("Enter the line number where the guest(starting from 1)");
        Integer id = HotelAdministrator.getInstance().getGuestIdByNumberOnList(textWorker.getIntegerInput() - 1);
        textWorker.println(HotelAdministrator.getInstance().getSortRoomsByPrice());
        textWorker.println("Enter the line number where there is a  room (starting from 1)");
        Integer number = HotelAdministrator.getInstance().getRoomNumberByNumberOnList(textWorker.getIntegerInput() - 1);
        textWorker.println(HotelAdministrator.getInstance().getSortListServiceGuestByCategory(id, number));

    }
}
