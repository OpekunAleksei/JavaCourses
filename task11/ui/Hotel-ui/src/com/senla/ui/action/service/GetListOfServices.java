/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.action.service;

import com.senla.ui.api.IAction;
import com.senla.ui.utils.Request;
import com.senla.ui.utils.TextWorker;

public class GetListOfServices implements IAction {

     

    @Override
    public void execute() {
        TextWorker.getInstance().println(Request.getInstance().pull("getListOfServices"));
    }
}
