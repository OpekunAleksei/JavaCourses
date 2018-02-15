/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.daoimpl;

import com.senla.hotel.api.dao.IServiceDao;
import com.senla.hotel.dbconnection.DbConnection;
import com.senla.hotel.entity.Service;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

public class ServiceDaoImpl implements IServiceDao {

    private final DbConnection dbConnection = DbConnection.getInstance();
    private static Logger logger = Logger.getLogger(ServiceDaoImpl.class);

    @Override
    public List<Service> getAll(String sad) {
        try (Statement statement = dbConnection.getConnection().createStatement()) {
            List<Service> list = new ArrayList<>();
            ResultSet rs = statement.executeQuery(
                    "SELECT * FROM service");
            while (rs.next()) {
                Service service = new Service(rs.getInt("price"), rs.getString("category"), rs.getInt("idservice"));
                list.add(service);
            }
            return list;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            return null;
        }

    }

    @Override
    public void changePrice(Integer id, Integer price) {
        try {

            try (PreparedStatement ps = dbConnection.getConnection().prepareStatement("update service set price=? where idservice=?")) {
                ps.setInt(2, id);
                ps.setInt(1, price);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {

            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public void setImportServices(List<Service> list) {
        try (Statement statement = dbConnection.getConnection().createStatement()) {
            for (int i = 0; i < list.size(); i++) {
                ResultSet rs = statement.executeQuery(
                        "SELECT category FROM service where idservice =" + list.get(i).getId());
                if (rs.next()) {
                    update(list.get(i));
                } else {
                    create(list.get(i));
                }

            }
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }

    }

    @Override
    public Integer getIdByNumberOnlist(Integer number) {
        return getAll(null).get(number).getId();
    }

    @Override
    public Service getById(Integer id) {
        try (Statement statement = dbConnection.getConnection().createStatement()) {
            Service service = null;
            ResultSet rs = statement.executeQuery(
                    "SELECT * FROM service where idservice =" + id);
            while (rs.next()) {
                service = new Service(rs.getInt("price"), rs.getString("category"), id);
            }
            return service;
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void update(Service entity) {
        try {
            try (PreparedStatement ps = dbConnection.getConnection().prepareStatement("update service set price=?,category=? where idservice=?")) {
                ps.setString(2, entity.getCategory());
                ps.setInt(1, entity.getPrice());
                ps.setInt(3, entity.getId());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public void create(Service entity) {
        try {
            try (PreparedStatement ps = dbConnection.getConnection().prepareStatement("insert into service(category,price) values (?,?)")) {
                ps.setString(1, entity.getCategory());
                ps.setInt(2, entity.getPrice());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            logger.error(new Date() + " " + ex.getMessage());
        }
    }

    @Override
    public List<Service> getById(List<Integer> id) {
        List<Service> services = new ArrayList();
        for (Integer id1 : id) {
            services.add(getById(id1));
        }
        return services;
    }

    @Override
    public Service getMiracleService(Integer price, String category) {
        Service miracleService = new Service(price, category, null);
        return miracleService;
    }

}
