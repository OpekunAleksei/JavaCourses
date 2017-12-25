/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.rooms;

import com.senla.hotel.utils.DataParser;
import com.senla.ui.utils.TextWorker;
import com.senla.ui.api.IAction;
import com.senla.hotel.request.Request;

public class GetSortRoomByPrice implements IAction {
private final DataParser dataParser = new DataParser();
    private TextWorker textWorker = new TextWorker();

    @Override
    public void execute() {

        textWorker.println(dataParser.parseData(Request.getInstance().pull("GetSortRoomByPrice")));

    }
}
