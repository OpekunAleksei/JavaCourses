package com.senla.opekun.eqipmentrental.web.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.senla.opekun.eqipmentrental.api.token.ITokenRepository;
import com.senla.opekun.eqipmentrental.api.utils.IResponseBuilder;
import com.senla.opekun.eqipmentrental.model.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public class AuthenticationFilter implements Filter {

    public static final String TOKEN = "Authorization";
    public static final String USER = "user";
    @Autowired
    private ITokenRepository tokenRepository;
    @Autowired
    private IResponseBuilder responseBuilder;
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader(TOKEN);
        User user = tokenRepository.getUserByToken(token);
        if (user != null) {
            chain.doFilter(request, response);
        } else {
            mapper.writeValue(response.getWriter(), responseBuilder.createResponse(Boolean.FALSE, "7", null));
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                filterConfig.getServletContext());
    }
}
