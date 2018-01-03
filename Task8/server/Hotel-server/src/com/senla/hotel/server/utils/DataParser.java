/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.server.utils;

import com.senla.hotel.api.facade.IHotelAdministrator;
import com.senla.hotel.utils.Logger;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class DataParser {

    private final IHotelAdministrator hotelAdministrator;
    private final Logger logger = new Logger();

    public DataParser(IHotelAdministrator hotelAdministrator) {
        this.hotelAdministrator = hotelAdministrator;

    }

    private String[] parseData = null;

    public String setInputData(String data) {
        try {
            String result = null;
            String[] arr = data.split("/");
            if (arr.length > 1) {
                parseData = arr[1].split(";");
                result = (String) this.hotelAdministrator.getClass().getMethod(arr[0], getParametrs(parseData)).invoke(this.hotelAdministrator, (Object[]) parseData);
            } else {
                result = (String) this.hotelAdministrator.getClass().getMethod(arr[0]).invoke(this.hotelAdministrator);
            }
            return result;
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            logger.writeErrToFile("Problem with server", e);
            return null;
        }
    }

    private Class[] getParametrs(String[] arr) {
        List<Class> parametrs = new ArrayList<>();
        for (String parseData1 : arr) {
            parametrs.add(parseData1.getClass());
        }
        return parametrs.toArray(new Class[arr.length]);
    }
}
