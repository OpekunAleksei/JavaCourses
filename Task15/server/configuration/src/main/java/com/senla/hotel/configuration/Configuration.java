/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.configuration;

import java.io.FileInputStream;
import java.io.IOException;
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

        try (FileInputStream inputStream = new FileInputStream("D:\\1\\configuration\\src\\main\\resources\\com\\senla\\hotel\\configuration/injectProperties.properties")) {
            injectProperties.load(inputStream);
        } catch (IOException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
        try (FileInputStream inputStream = new FileInputStream("D:\\1\\configuration\\src\\main\\resources\\com\\senla\\hotel\\configuration/properties.properties")) {
            properties.load(inputStream);
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

    public String getAuditPath() {
        return properties.getProperty("AUDIT_PATH");
    }

    public Boolean getAbilityChangeRoomStatus() {
        return Boolean.valueOf(properties.getProperty("ABILITY_CHANGE_ROOM_STATUS"));
    }

    public String getCsvPath() {
        return properties.getProperty("CSV_PATH");

    }

}
