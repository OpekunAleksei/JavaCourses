package com.senla.hotel.web;

import com.senla.hotel.api.facade.IHotelAdministrator;
import com.senla.hotel.utils.ServletDataParser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RoomServlet extends HttpServlet {

    private final ServletDataParser servletDataParser = new ServletDataParser();
    private IHotelAdministrator hotelAdministrator;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        hotelAdministrator = (IHotelAdministrator) request.getSession().getAttribute("administrator");
        servletDataParser.createResponse(response, hotelAdministrator.getListOfRooms("zero", false, servletDataParser.getInformation(request)));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        hotelAdministrator = (IHotelAdministrator) req.getSession().getAttribute("administrator");
        servletDataParser.getJsonObjectFromReques(req);
        Integer numberOfRoom = (Integer) servletDataParser.getDataFronJson("numberOfRoom");
        Integer price = (Integer) servletDataParser.getDataFronJson("price");
        hotelAdministrator.changeRoomPrice(numberOfRoom, price, servletDataParser.getInformation(req));
    }

}
