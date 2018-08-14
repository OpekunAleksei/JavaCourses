package com.senla.opekun.eqipmentrental.api.token;

import com.senla.opekun.eqipmentrental.model.User;

/**
 * Класс для создания web токена
 *
 * @author Алексей Опекун
 * @version 1.0
 */
public interface ITokenBuilder {

    /**
     * @param user используется для создания токена
     * @return токен созданный для данного пользователя
     */
    public String createWebToken(User user);
}
