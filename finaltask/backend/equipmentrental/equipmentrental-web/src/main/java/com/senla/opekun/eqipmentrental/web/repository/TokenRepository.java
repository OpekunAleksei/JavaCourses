package com.senla.opekun.eqipmentrental.web.repository;

import com.senla.opekun.eqipmentrental.api.token.ITokenRepository;
import com.senla.opekun.eqipmentrental.model.User;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Repository
public class TokenRepository implements ITokenRepository {

    private final Map<String, User> usersToken;

    public TokenRepository() {
        usersToken = new HashMap<String, User>();
    }

    @Override
    public User getUserByToken(String token) {
        return this.usersToken.get(token);
    }

    @Override
    public void setUserToken(User user, String token) {
        this.usersToken.put(token, user);
    }

    @Override
    public void destroyUserToken(String token) {
        this.usersToken.remove(token);
    }

}
