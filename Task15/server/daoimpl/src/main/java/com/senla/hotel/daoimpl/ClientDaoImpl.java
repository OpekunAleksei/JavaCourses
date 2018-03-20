/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.daoimpl;

import com.senla.hotel.api.dao.IClientDao;
import com.senla.hotel.entity.Client;
import java.sql.SQLException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ClientDaoImpl extends AbstractDao<Client> implements IClientDao {

    public ClientDaoImpl() {
        super(new Client());
    }

    @Override
    public Client createMiracleClient(String login, String password) {
        Client client = new Client(password, login, null, null);
        return client;
    }

    @Override
    public Client getClient(Session session, String login, String password) {
        Criteria criteria = session.createCriteria(Client.class).add(Restrictions.eq("login", login)).add(Restrictions.eq("password", password));
        return (Client) criteria.list().get(0);
    }

    @Override
    public void signInOut(Session session, Client client, String token) throws SQLException {
        client.setToken(token);
        update(session, client);
    }

}
