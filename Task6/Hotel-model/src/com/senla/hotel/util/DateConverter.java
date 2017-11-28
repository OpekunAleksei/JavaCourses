/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.util;

import java.text.SimpleDateFormat;

public class DateConverter {

    private final SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    public SimpleDateFormat getDateFormat() {
        return format;
    }

}
