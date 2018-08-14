/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.opekun.eqipmentrental.api.utils;

import java.util.Map;

/**
 * Класс для создания ответа посылаемого на клиентскую часть
 *
 * @author Алексей Опекун
 * @version 1.0
 */
public interface IResponseBuilder {

    public Map<String, Object> createResponse(Boolean success, String errMsg, Object data);
}
