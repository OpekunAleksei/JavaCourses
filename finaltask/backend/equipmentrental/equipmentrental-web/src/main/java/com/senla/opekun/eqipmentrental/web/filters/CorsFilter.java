package com.senla.opekun.eqipmentrental.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public class CorsFilter implements Filter {

    private final static String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    private final static String ACCESS_CONTROL_ALLOW_ORIGIN_VALUE = "*";
    private final static String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    private final static String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
    private final static String ACCESS_CONTROL_ALLOW_METHODS_VALUE = "GET, OPTIONS, HEAD, PUT, POST,DELETE";
    private final static String ACCESS_CONTROL_ALLOW_HEADERS_VALUE = "Origin, Content-Type, X-Auth-Token , Authorization";
    private final static String OPTIONS = "OPTIONS";

    public CorsFilter() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        ((HttpServletResponse) response).addHeader(ACCESS_CONTROL_ALLOW_ORIGIN, ACCESS_CONTROL_ALLOW_ORIGIN_VALUE);
        ((HttpServletResponse) response).addHeader(ACCESS_CONTROL_ALLOW_METHODS, ACCESS_CONTROL_ALLOW_METHODS_VALUE);
        ((HttpServletResponse) response).addHeader(ACCESS_CONTROL_ALLOW_HEADERS, ACCESS_CONTROL_ALLOW_HEADERS_VALUE);
        HttpServletResponse resp = (HttpServletResponse) response;
        if (req.getMethod().equals(OPTIONS)) {
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) {

    }
}
