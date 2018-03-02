/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.utils;

public class Converter {

    public Boolean booleanConverter(String name) {
        return "true".equals(name);
    }

    public Boolean booleanConverter(Integer busy) {
        return busy == 0;
    }
}
