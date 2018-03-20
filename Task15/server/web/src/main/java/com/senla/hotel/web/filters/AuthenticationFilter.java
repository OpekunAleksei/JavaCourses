package com.senla.hotel.web.filters;

import com.senla.hotel.api.facade.IHotelAdministrator;
import com.senla.hotel.facade.HotelAdministrator;
import com.senla.hotel.utils.ServletDataParser;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationFilter implements Filter {

    private static final boolean debug = true;
    private final ServletDataParser servletDataParser = new ServletDataParser();
    private FilterConfig filterConfig = null;
    private final IHotelAdministrator hotelAdministrator = HotelAdministrator.getInstance();

    public AuthenticationFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        Boolean access = (Boolean) req.getSession().getAttribute("access");
        if (access != null) {
            if (access == true) {
                req.getSession().setAttribute("administrator", hotelAdministrator);
                chain.doFilter(request, response);
            }
        } else {
            res.getOutputStream().print("Login or passsword uncorrect");
        }
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }

}
