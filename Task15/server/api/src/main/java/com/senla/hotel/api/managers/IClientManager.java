/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.managers;

import com.senla.hotel.entity.Client;

public interface IClientManager {

    public void registerUser(String login, String password) throws Exception;

    public void signOut(Client client) throws Exception;

    public void signIn(String login, String password, String token) throws Exception;

    public Client getCLient(String login, String password) throws Exception;
}
