package com.senla.ui.action.imports;


import com.senla.hotel.facade.HotelAdministrator;
import com.senla.ui.api.IAction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Exit implements IAction{
    
    @Override
    public void execute() {
       HotelAdministrator.getInstance().writeData();
    }
}
