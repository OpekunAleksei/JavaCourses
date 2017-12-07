/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.factory;

import com.senla.hotel.utils.Logger;
import java.lang.reflect.InvocationTargetException;

public class ManagerFactory {

    private final Logger logger;

    public ManagerFactory() {
        logger = new Logger();
    }

    public Object getObject(Class managerClass, String path) {

        try {
            return managerClass.getConstructor(String.class).newInstance(path);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            logger.writeErrToFile("Manager factory broblem", ex);
            return null;
        }
    }
}
