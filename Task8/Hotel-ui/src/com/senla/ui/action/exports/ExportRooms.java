/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.exports;

import com.senla.ui.api.IAction;
import com.senla.hotel.request.Request;

public class ExportRooms implements IAction {

    @Override
    public void execute() {
        Request.getInstance().pull("ExportRooms");
    }
}
