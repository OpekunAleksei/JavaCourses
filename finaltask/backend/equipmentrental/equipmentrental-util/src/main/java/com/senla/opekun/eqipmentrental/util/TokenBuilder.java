package com.senla.opekun.eqipmentrental.util;

import com.senla.opekun.eqipmentrental.api.token.ITokenBuilder;
import com.senla.opekun.eqipmentrental.model.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Component
public class TokenBuilder implements ITokenBuilder {

    public static final String KEY = "abc123";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";

    @Override
    public String createWebToken(User user) {
        Map<String, Object> tokenData = new HashMap<String, Object>();
        tokenData.put(LOGIN, user.getLogin());
        tokenData.put(PASSWORD, user.getPassword());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 100);
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setExpiration(calendar.getTime());
        jwtBuilder.setClaims(tokenData);
        String token = jwtBuilder.signWith(SignatureAlgorithm.HS512, KEY).compact();
        return token;
    }
}
