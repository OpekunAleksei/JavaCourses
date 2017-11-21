/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.facade;

import com.senla.ui.action.imports.ImportHistory;
import com.senla.ui.managers.Builder;
import com.senla.ui.managers.Navigator;

import com.senla.ui.utils.TextWorker;

public class MenuController {

    private TextWorker textWorker = new TextWorker();

    public void run() {

        Builder builder = new Builder();
        builder.buildMainMenu();
        Navigator navigator = new Navigator(builder.getRootMenu());
        ImportHistory importHistory = new ImportHistory();
        importHistory.execute();
        do {
            navigator.printMenu();

            navigator.navigate(textWorker.getIntegerInput());
        } while (navigator.getCurentMenu() != null);
    }

}
