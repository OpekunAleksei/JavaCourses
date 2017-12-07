/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.configuration;

import com.senla.hotel.utils.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private Properties properties;
    private final Logger logger;

    public Configuration() {
        logger = new Logger();
        properties = new Properties();
        try (InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("resources/properties.properties")) {
            properties.load(is);
        } catch (IOException ex) {
            logger.writeErrToFile("Problem with properies file", ex);
        }
    }

    public Integer getNumberRecordsGuests() {
        return Integer.valueOf(properties.getProperty("NUMBER_RECORDS_GUESTS"));
    }

    public Boolean getAbilityChangeRoomStatus() {
        return Boolean.valueOf(properties.getProperty("NUMBER_RECORDS_GUESTS"));
    }

    public String getGuestPath() {
        return properties.getProperty("GUEST_PATH");
    }

    public String getCsvPath() {
        return properties.getProperty("CSV_PATH");
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
