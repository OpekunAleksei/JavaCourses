/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.factory;



import java.util.Date;
import java.util.Map;
import org.apache.log4j.Logger;


public class ManagerFactory {

    private static Logger logger = Logger.getLogger(ManagerFactory.class) ;
    private final Map<String, String> injectProperties;

    public ManagerFactory(Map<String, String> injectProperties) {
        this.injectProperties = injectProperties;
       
    }

    public Object getObject(Class managerClass) {
      
        try {      
            Class someObject = Class.forName(injectProperties.get(managerClass.getName()));
       
            return someObject.newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | SecurityException | ClassNotFoundException ex) {
        logger.error(new Date() + " " + ex.getMessage());
     
            return null;
        }
    }
}
