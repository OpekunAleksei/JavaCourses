package com.senla.hotel.web;

import com.senla.hotel.utils.Constants;
import com.senla.hotel.api.facade.IHotelAdministrator;
import com.senla.hotel.entity.Client;
import com.senla.hotel.enums.SortName;
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

public class RoomServlet extends HttpServlet {

    private final ServletDataParser servletDataParser = new ServletDataParser();
    private final IHotelAdministrator hotelAdministrator = HotelAdministrator.getInstance();
    private static final Logger logger = Logger.getLogger(RoomServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            servletDataParser.createResponse(response, hotelAdministrator.getListOfRooms(SortName.zero.toString(), false));
            hotelAdministrator.auditData((Client) request.getSession().getAttribute(Constants.USER), Constants.GET_RESOURCE);
        } catch (IOException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            JSONObject json = servletDataParser.getJsonObjectFromReques(req);
            hotelAdministrator.changeRoomPrice(json.getInt(Constants.LINE_NUMBER), json.getInt(Constants.PRICE));
        } catch (IOException | JSONException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }
}
