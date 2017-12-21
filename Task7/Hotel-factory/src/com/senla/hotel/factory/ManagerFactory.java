/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.factory;

import com.senla.hotel.utils.Logger;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


public class ManagerFactory {

    private final Logger logger;
    private final Map<String, String> injectProperties;

    public ManagerFactory(Map<String, String> injectProperties) {
        this.injectProperties = injectProperties;
        logger = new Logger();
    }

    public Object getObject(Class managerClass, String path) {
      
        try {      
            Class someObject = Class.forName(injectProperties.get(managerClass.getName()));      
            return someObject.getConstructor(String.class).newInstance(path);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException ex) {
            logger.writeErrToFile("Manager factory broblem", ex);

            return null;
        }
    }
}
