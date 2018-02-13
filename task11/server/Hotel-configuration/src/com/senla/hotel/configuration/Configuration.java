/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;

public class Configuration {

    private Properties properties;
    private Properties injectProperties;
    private static Logger logger = Logger.getLogger(Configuration.class);

    public Configuration() {

        properties = new Properties();
        injectProperties = new Properties();
        try (InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("resources/injectProperties.properties")) {
            injectProperties.load(is);
        } catch (IOException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
        try (InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("resources/properties.properties")) {
            properties.load(is);
        } catch (IOException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    public Map<String, String> getInjectProperties() {
        return (Map<String, String>) injectProperties.clone();
    }

    public Integer getNumberRecordsGuests() {
        return Integer.valueOf(properties.getProperty("NUMBER_RECORDS_GUESTS"));
    }

    public Boolean getAbilityChangeRoomStatus() {
        return Boolean.valueOf(properties.getProperty("ABILITY_CHANGE_ROOM_STATUS"));
    }

    public String getGuestPath() {
        return properties.getProperty("GUEST_PATH");
    }

    public String getCsvPath() {
        return properties.getProperty("CSV_PATH");

    }

    public String getURL() {
        return String.valueOf(properties.getProperty("DB_URL"));
    }

    public String getName() {
        return String.valueOf(properties.getProperty("DB_NAME"));
    }

    public String getpassword() {
        return String.valueOf(properties.getProperty("DB_PASSWORD"));
    }

    public String getDriverName() {
        return String.valueOf(properties.getProperty("DB_DRIVER_NAME"));
    }

}
