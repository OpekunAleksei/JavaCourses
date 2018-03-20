/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.managers;

public interface IClientManager {

    public void registerUser(String login, String password) throws Exception;

    public void signOut(String login, String password) throws Exception;

    public void signIn(String login, String password, String token) throws Exception;

    public String getToken(String login, String password) throws Exception;
}
