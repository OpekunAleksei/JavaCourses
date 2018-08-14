package com.senla.opekun.eqipmentrental.api.token;

import com.senla.opekun.eqipmentrental.model.User;

/**
 * Класс для хранения токенов
 *
 * @author Алексей Опекун
 * @version 1.0
 */
public interface ITokenRepository {

    public User getUserByToken(String token);

    public void setUserToken(User user, String token);

    public void destroyUserToken(String token);
}
