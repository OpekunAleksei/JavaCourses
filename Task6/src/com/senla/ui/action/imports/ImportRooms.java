/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.imports;

import com.senla.hotel.facade.HotelAdministrator;
import com.senla.ui.api.IAction;
import com.senla.ui.utils.TextWorker;

public class ImportRooms implements IAction {
    private final TextWorker textWorker = new TextWorker();
    @Override
    public void execute() {
                textWorker.println("Please enter path to file");
        String path = textWorker.getStringInput();
     HotelAdministrator.getInstance().importRooms(path);
    }
}
