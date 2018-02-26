/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.daoimpl;

import com.senla.hotel.api.dao.IServiceDao;

import com.senla.hotel.entity.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ServiceDaoImpl extends AbstractDao<Service> implements IServiceDao {



    @Override
    public void changePrice(Connection connection, Integer id, Integer price) throws SQLException {
        String SQLQuery = "update service set price=? where idservice=?";
        try (PreparedStatement ps = connection.prepareStatement(SQLQuery)) {
            ps.setInt(2, id);
            ps.setInt(1, price);
            ps.executeUpdate();
        }

    }

    @Override
    public void setImportServices(Session session, List<Service> list) throws SQLException {

        for (Service list1 : list) {
            session.saveOrUpdate(list1);
        }

    }

    @Override
    public Integer getIdByNumberOnlist(Session session, Integer number) throws SQLException {
        return getAll(session, "zero").get(number).getId();
    }

    @Override
    public List<Service> getById(Session session, List<Integer> id) throws SQLException {
        List<Service> services = new ArrayList();
        for (Integer id1 : id) {
            services.add(getById(session, id1));
        }
        return services;
    }

    @Override
    public Service getMiracleService(Integer price, String category) {
        Service miracleService = new Service(price, category, null);
        return miracleService;
    }

 
    @Override
    protected List<Service> parseQueryGetById(Session session, int id) throws SQLException {
        Criteria criteria = session.createCriteria(Service.class).add(Restrictions.idEq(id));
        return criteria.list();
    }

    @Override
    protected List<Service> parseQueryGetSortingAllEntity(Session session, String condition) throws SQLException {
        return null;
    }

    @Override
    protected List<Service> parseQueryGetAllEntity(Session session) throws SQLException {
        Criteria criteria = session.createCriteria(Service.class);
        return criteria.list();
    }


}
