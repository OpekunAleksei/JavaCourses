/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.web;

import com.senla.hotel.utils.Constants;
import com.senla.hotel.api.facade.IHotelAdministrator;
import com.senla.hotel.facade.HotelAdministrator;
import com.senla.hotel.utils.ServletDataParser;
import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class RegistrationServlet extends HttpServlet {

    private final ServletDataParser servletDataParser = new ServletDataParser();
    private final IHotelAdministrator hotelAdministrator = HotelAdministrator.getInstance();
    private static Logger logger = Logger.getLogger(RegistrationServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        try {
            JSONObject json = servletDataParser.getJsonObjectFromReques(req);
            hotelAdministrator.registerUser(json.getString(Constants.LOGIN), json.getString(Constants.PASSWORD));
        } catch (IOException | JSONException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }
}
