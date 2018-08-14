/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.opekun.eqipmentrental.api.utils;

/**
 * Класс для получения кода ошибки по названию ошибки
 *
 * @author Алексей Опекун
 * @version 1.0
 */
public interface IErrMsgHandler {

    public String getErrCodeByException(String name);

}
