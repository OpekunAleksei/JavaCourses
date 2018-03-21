/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.managers;

import com.senla.hotel.api.dao.IClientDao;
import com.senla.hotel.api.managers.IClientManager;
import com.senla.hotel.daoimpl.ClientDaoImpl;
import com.senla.hotel.entity.Client;
import com.senla.hotel.hibernateutil.HibernateUtil;
import java.sql.SQLException;
import java.util.Date;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientManager implements IClientManager {

    private final IClientDao clientDao;
    private static Logger logger = Logger.getLogger(ClientManager.class);

    public ClientManager() {
        this.clientDao = new ClientDaoImpl();
    }

    @Override
    public Client getCLient(String login, String password) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Client client = clientDao.getClient(session, login, password);
            transaction.commit();
            return client;
        } catch (Exception ex) {
            logger.error(new Date() + " " + ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception();
        }
    }

    @Override
    public void registerUser(String login, String password) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            clientDao.create(session, clientDao.createMiracleClient(login, password));
            transaction.commit();
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception();
        }
    }

    @Override
    public void signIn(String login, String password, String token) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            clientDao.signInOut(session, clientDao.getClient(session, login, password), token);
            transaction.commit();
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception();
        }
    }

    @Override
    public void signOut(Client client) throws Exception {
        Session session = HibernateUtil.getIstance().getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            clientDao.signInOut(session, client, null);
            transaction.commit();
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception();
        }
    }
}
