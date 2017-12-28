/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    private final SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    public String parseDate(Date date) {
        return format.format(date);
    }
        public Date parseDate(String date) throws ParseException {
        return format.parse(date);
    }
}
