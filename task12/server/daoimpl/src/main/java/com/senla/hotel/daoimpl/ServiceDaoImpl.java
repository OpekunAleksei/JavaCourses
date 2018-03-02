/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.daoimpl;

import com.senla.hotel.api.dao.IServiceDao;

import com.senla.hotel.entity.Service;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ServiceDaoImpl extends AbstractDao<Service> implements IServiceDao {

    @Override
    public void changePrice(Session session, Integer id, Integer price) throws SQLException {
        Service service = getById(session, id);
        service.setPrice(price);
        update(session, service);

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
