/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.storages;

import com.senla.hotel.configuration.Configuration;

public class StoragePropertys {

    private final Configuration configuration;

    public StoragePropertys() {

        configuration = new Configuration();

    }

    public Integer getNumberLeftGuest() {
        return configuration.getNumberRecordsGuests();
    }

    public Boolean getAbility() {
        return configuration.getAbilityChange_Room_Status();
    }

    public String getRoomPath() {
        return configuration.getRoomPath();
    }

    public String getGuestPath() {
        return configuration.getGuestPath();
    }
    public String getHistoryPath() {
        return configuration.getHistoryPath();
    }
    public String getServicePath() {
        return configuration.getServicePath();
    }
}
