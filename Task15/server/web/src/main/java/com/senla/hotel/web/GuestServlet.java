package com.senla.hotel.web;

import com.senla.hotel.utils.Constants;
import com.senla.hotel.api.facade.IHotelAdministrator;
import com.senla.hotel.entity.Client;
import com.senla.hotel.enums.SortName;
import com.senla.hotel.facade.HotelAdministrator;
import com.senla.hotel.utils.ServletDataParser;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class GuestServlet extends HttpServlet {

    private final ServletDataParser servletDataParser = new ServletDataParser();
    private final IHotelAdministrator hotelAdministrator = HotelAdministrator.getInstance();
    private static Logger logger = Logger.getLogger(LogInServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            servletDataParser.createResponse(response, hotelAdministrator.getListGuest(SortName.zero.toString()));
            hotelAdministrator.auditData((Client) request.getSession().getAttribute(Constants.USER), Constants.GET_RESOURCE);

        } catch (IOException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {

        try {
            JSONObject json = servletDataParser.getJsonObjectFromReques(request);
            hotelAdministrator.createGuest(json.getString(Constants.NAME), json.getString(Constants.ARRIVAL_DATE), json.getString(Constants.DEPARTURE_DATE));

        } catch (IOException | JSONException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }
}
