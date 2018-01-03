/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.guest;

import com.senla.hotel.utils.DataParser;
import com.senla.ui.api.IAction;
import com.senla.ui.utils.Request;
import com.senla.ui.utils.TextWorker;

public class GetSortGuestByName implements IAction {

    private final DataParser dataParser = new DataParser();
    private final TextWorker textWorker = new TextWorker();

    @Override
    public void execute() {
        textWorker.println(Request.getInstance().pull("getSortGuestByName"));
    }
}
