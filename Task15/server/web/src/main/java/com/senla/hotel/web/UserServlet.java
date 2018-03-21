package com.senla.hotel.web;

import com.senla.hotel.api.facade.IHotelAdministrator;
import com.senla.hotel.entity.Client;
import com.senla.hotel.facade.HotelAdministrator;
import com.senla.hotel.utils.ServletDataParser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {

    private final ServletDataParser servletDataParser = new ServletDataParser();
    private final IHotelAdministrator hotelAdministrator = HotelAdministrator.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getHeader("login");
        String password = req.getHeader("password");
        String token = servletDataParser.createWebToken(name, password);
        hotelAdministrator.signIn(name, password, token, servletDataParser.getInformation(req));
        Client client = hotelAdministrator.getClient(name, password);
        if (client != null) {
            req.getSession().setAttribute("user", client);
            req.getSession().setAttribute("login", name);
            servletDataParser.createResponse(resp, client.getToken());
        } else {
            servletDataParser.createResponse(resp, "Wrong login or password");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        hotelAdministrator.signOut((Client) req.getSession().getAttribute("user"), servletDataParser.getInformation(req));
        req.getSession().invalidate();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getHeader("login");
        String password = req.getHeader("password");
        hotelAdministrator.registerUser(name, password, servletDataParser.getInformation(req));
    }
}
