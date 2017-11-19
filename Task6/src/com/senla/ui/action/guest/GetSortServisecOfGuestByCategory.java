package com.senla.ui.action.guest;

import com.senla.hotel.facade.HotelAdministrator;

import com.senla.ui.api.IAction;
import com.senla.ui.utils.TextWorker;

public class GetSortServisecOfGuestByCategory implements IAction {

    private TextWorker textWorker = new TextWorker();

    @Override
    public void execute() {
        textWorker.println(HotelAdministrator.getInstance().getSortGuestByName());
        textWorker.println("Enter the line number where the guest(starting from 1)");
        textWorker.println(HotelAdministrator.getInstance().getSortListServiceGuestByCategory(HotelAdministrator.getInstance().getGuestIdByNumberOnList(textWorker.getIntegerInput() - 1)));

    }
}
