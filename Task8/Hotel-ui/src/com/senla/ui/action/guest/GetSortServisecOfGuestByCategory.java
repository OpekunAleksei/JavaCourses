package com.senla.ui.action.guest;

import com.senla.ui.action.rooms.GetSortRoomByCapacity;
import com.senla.ui.api.IAction;
import com.senla.ui.utils.Request;
import com.senla.ui.utils.TextWorker;

public class GetSortServisecOfGuestByCategory implements IAction {

   
    private final TextWorker textWorker = new TextWorker();
    private final GetSortGuestByName getSortGuestByName = new GetSortGuestByName();
    private final GetSortRoomByCapacity getSortRoomByCapacity = new GetSortRoomByCapacity();

    @Override
    public void execute() {
      getSortGuestByName.execute();
  
        textWorker.println("Enter the line number where the guest(starting from 1)");
        Integer id = textWorker.getIntegerInput() - 1;
        getSortRoomByCapacity.execute();
        textWorker.println("Enter the line number where there is a  room (starting from 1)");
        Integer number = textWorker.getIntegerInput() - 1;

        textWorker.println(Request.getInstance().pull(textWorker.createLine("getSortServisecOfGuestByCategory", textWorker.createData(id.toString(), number.toString()))));

    }
}
