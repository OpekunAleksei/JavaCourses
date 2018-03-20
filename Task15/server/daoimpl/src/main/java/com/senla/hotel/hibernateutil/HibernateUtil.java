/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.hibernateutil;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

public class HibernateUtil {

    private SessionFactory sessionFactory;
    private static HibernateUtil hibernateUtil;

    public static HibernateUtil getIstance() {
        if (hibernateUtil == null) {
            hibernateUtil = new HibernateUtil();
        }
        return hibernateUtil;
    }

    public HibernateUtil() {
        createSessionFactory();
    }

    private void createSessionFactory() {
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
