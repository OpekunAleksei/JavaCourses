/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.guest;

import com.senla.hotel.enums.SortName;
import com.senla.ui.api.IAction;
import com.senla.ui.utils.Request;
import com.senla.ui.utils.TextWorker;

public class GetSortGuestByName implements IAction {



    @Override
    public void execute() {
          
        TextWorker.getInstance().println(Request.getInstance().pull(TextWorker.getInstance().createLine("getListGuest", TextWorker.getInstance().createData(SortName.name.toString()))));
   
    }
}
