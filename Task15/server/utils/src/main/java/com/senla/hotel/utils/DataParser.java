/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.utils;

import com.senla.hotel.enums.RoomStatus;
import java.util.Map;

public class DataParser {

    private final StringBuilder builder = new StringBuilder();

   

    public String createEntityList(Map map, String valuesSeparator, String csvGuestData) {
        this.builder.setLength(0);

        for (int j = 0; j < map.size(); j++) {
            this.builder.append(map.get(j));
            this.builder.append(valuesSeparator);
        }
        this.builder.append("\n");
        if (csvGuestData != null) {
            this.builder.append(csvGuestData);
        }
        return this.builder.toString();
    }

    public String createFirstLine(Map map, String valuesSeparator) {
        this.builder.setLength(0);
        for (int j = 0; j < map.size(); j++) {
            this.builder.append(map.get(j));
            this.builder.append(valuesSeparator);
        }
        return this.builder.toString();
    }

    public RoomStatus getRoomStatus(String status) {
        if ("repaired".equals(status)) {
            return RoomStatus.repaired;
        } else {
            return RoomStatus.serviced;
        }
    }
}
