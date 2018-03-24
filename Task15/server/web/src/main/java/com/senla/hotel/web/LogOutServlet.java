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
import java.util.Date;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

public class LogOutServlet extends HttpServlet {

    private final IHotelAdministrator hotelAdministrator = HotelAdministrator.getInstance();
    private static Logger logger = Logger.getLogger(LogOutServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Client client = (Client) req.getSession().getAttribute(Constants.USER);
            hotelAdministrator.signOut(client);
            hotelAdministrator.auditData(client, Constants.SIGN_IN);
            req.getSession().invalidate();
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }
}
