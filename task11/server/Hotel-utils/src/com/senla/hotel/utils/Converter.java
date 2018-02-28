/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.utils;

import com.senla.hotel.enums.RoomStatus;

public class Converter {

    public RoomStatus getStatus(String name) {
        if (RoomStatus.repaired.toString().equals(name)) {
            return RoomStatus.repaired;
        } else {
            return RoomStatus.serviced;
        }
    }

    public Boolean booleanConverter(String name) {
        return "true".equals(name);
    }

    public Boolean booleanConverter(Integer busy) {
        return busy == 0;
    }
}
