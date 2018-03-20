/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.dao;

import com.senla.hotel.entity.Client;
import java.sql.SQLException;
import org.hibernate.Session;

public interface IClientDao extends IGenericDao<Client> {

    public Client createMiracleClient(String login, String password);

    public Client getClient(Session session, String login, String password);

    public void signInOut(Session session, Client client, String token) throws SQLException;

}
