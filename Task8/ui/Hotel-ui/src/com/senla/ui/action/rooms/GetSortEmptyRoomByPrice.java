/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.rooms;

import com.senla.ui.utils.TextWorker;
import com.senla.ui.api.IAction;
import com.senla.ui.utils.Request;
public class GetSortEmptyRoomByPrice implements IAction {

    private TextWorker textWorker = new TextWorker();

    @Override
    public void execute() {

        textWorker.println(Request.getInstance().pull("getSortEmptyRoomsByPrice"));

    }
}
