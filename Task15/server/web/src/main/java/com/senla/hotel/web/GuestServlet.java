
package com.senla.hotel.web;

import com.senla.hotel.api.facade.IHotelAdministrator;
import com.senla.hotel.utils.ServletDataParser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuestServlet extends HttpServlet {

    private final ServletDataParser servletDataParser = new ServletDataParser();
    private IHotelAdministrator hotelAdministrator;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        hotelAdministrator = (IHotelAdministrator) request.getSession().getAttribute("administrator");
        servletDataParser.createResponse(response, hotelAdministrator.getListGuest("zero", servletDataParser.getInformation(request)));
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        hotelAdministrator = (IHotelAdministrator) request.getSession().getAttribute("administrator");
        servletDataParser.getJsonObjectFromReques(request);
        String name = (String) servletDataParser.getDataFronJson("name");
        String arrivalDate = (String) servletDataParser.getDataFronJson("arrivalDate");
        String departurreDate = (String) servletDataParser.getDataFronJson("departurreDate");
        hotelAdministrator.createGuest(name, arrivalDate, departurreDate, servletDataParser.getInformation(request));
    }

}
