/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.configuration;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Configuration {

    private Properties properties;

    public Configuration() {
        properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("resources/properties.properties"));
        } catch (IOException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Integer getNumberRecordsGuests() {
        return Integer.valueOf(properties.getProperty("NUMBER_RECORDS_GUESTS"));
    }

    public Boolean getAbilityChange_Room_Status() {
        return Boolean.valueOf(properties.getProperty("NUMBER_RECORDS_GUESTS"));
    }
 public String getGuestPath() {
        return properties.getProperty("GUEST_PATH");
    }
  public String getRoomPath() {
        return properties.getProperty("ROOM_PATH");
    }
   public String getServicePath() {
        return properties.getProperty("SERVICE_PATH");
    }
      public String getHistoryPath() {
        return properties.getProperty("HISTORY_PATH");
    }
}
