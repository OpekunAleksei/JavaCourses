/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.web;

import com.senla.hotel.utils.Constants;
import com.senla.hotel.api.facade.IHotelAdministrator;
import com.senla.hotel.entity.Client;
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

public class LogInServlet extends HttpServlet {

    private final ServletDataParser servletDataParser = new ServletDataParser();
    private final IHotelAdministrator hotelAdministrator = HotelAdministrator.getInstance();
    private static Logger logger = Logger.getLogger(LogInServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            JSONObject json = servletDataParser.getJsonObjectFromReques(req);
            String name = json.getString(Constants.LOGIN);
            String password = json.getString(Constants.PASSWORD);
            String token = servletDataParser.createWebToken(name, password);
            Client client = hotelAdministrator.getClient(name, password);
            if (client != null) {
                hotelAdministrator.signIn(client, token);
                req.getSession().setAttribute(Constants.USER, client);
                resp.getOutputStream().print(token);
                hotelAdministrator.auditData(client, Constants.SIGN_IN);
            }
        } catch (IOException | JSONException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }
}
