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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceDaoImpl extends AbstractDao<Service> implements IServiceDao {


    private final static String GET_ALL = "SELECT * FROM service";
    private final static String INSERT_SERVICE = "insert into service(category,price) values (?,?)";
    private final static String UPDATE_SERVICE = "update service set price= ?,category= ? where idservice= ?";
    private final static String GET_BY_ID = "SELECT * FROM service where idservice = ?";
    private final static String DELETE_SERVICE = "DELETE from service where idservice=?";

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
    public void setImportServices(Connection connection, List<Service> list) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            for (int i = 0; i < list.size(); i++) {
                ResultSet rs = statement.executeQuery(
                        "SELECT category FROM service where idservice =" + list.get(i).getId());
                if (rs.next()) {
                    update(connection, list.get(i));
                } else {
                    create(connection, list.get(i));
                }
            }
        }

    }

    @Override
    public Integer getIdByNumberOnlist(Connection connection, Integer number) throws SQLException {
        return getAll(connection, "zero").get(number).getId();
    }

    @Override
    public List<Service> getById(Connection connection, List<Integer> id) throws SQLException {
        List<Service> services = new ArrayList();
        for (Integer id1 : id) {
            services.add(getById(connection, id1));
        }
        return services;
    }

    @Override
    public Service getMiracleService(Integer price, String category) {
        Service miracleService = new Service(price, category, null);
        return miracleService;
    }

    @Override
    protected String getByIdQuery() {
        return GET_BY_ID;
    }

    @Override
    protected String getUpdateQuery() {
        return UPDATE_SERVICE;
    }

    @Override
    protected String getCreateQuery() {
        return INSERT_SERVICE;
    }

    @Override
    protected String getAllQuery() {
        return GET_ALL;
    }

    @Override
    protected String getSortingAllQuery() {
        return null;
    }

    @Override
    protected List<Service> parseQueryGetById(PreparedStatement ps, int id) throws SQLException {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        return parseQueryGetList(rs);
    }

    @Override
    protected List<Service> parseQueryGetSortingAllEntity(PreparedStatement ps, String condition) throws SQLException {
        return null;
    }

    @Override
    protected List<Service> parseQueryGetAllEntity(PreparedStatement ps) throws SQLException {
        ResultSet rs = ps.executeQuery();
        return parseQueryGetList(rs);
    }

    private List<Service> parseQueryGetList(ResultSet rs) throws SQLException {
        List<Service> list = new ArrayList();
        while (rs.next()) {
            Service service = new Service(rs.getInt("price"), rs.getString("category"), rs.getInt("idservice"));
            list.add(service);
        }
        return list;
    }

    @Override
    protected void parseQueryCreateEntity(PreparedStatement ps, Service object) throws SQLException {
        ps.setString(1, object.getCategory());
        ps.setInt(2, object.getPrice());
    }

    @Override
    protected void parseQueryUpdateEntity(PreparedStatement ps, Service object) throws SQLException {
        ps.setInt(1, object.getPrice());
        ps.setString(2, object.getCategory());
        ps.setInt(3, object.getId());
    }

    @Override
    protected String getDeleteQuery() {
        return DELETE_SERVICE;
    }

    @Override
    protected void parseQueryDeleteEntity(PreparedStatement ps, Service object) throws SQLException {
        ps.setInt(1, object.getId());
    }

}
