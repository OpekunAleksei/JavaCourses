/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.exports;

import com.senla.hotel.facade.HotelAdministrator;
import com.senla.ui.api.IAction;

/**
 *
 * @author elena
 */
public class ExportHistory implements IAction {

    @Override
    public void execute() {
        HotelAdministrator.getInstance().exportHistory();
    }
}
