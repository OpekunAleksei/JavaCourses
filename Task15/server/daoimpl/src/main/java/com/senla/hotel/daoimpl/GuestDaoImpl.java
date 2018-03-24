/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.daoimpl;

import com.senla.hotel.api.dao.IGuestDao;
import com.senla.hotel.entity.Guest;
import com.senla.hotel.enums.SortName;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;

public class GuestDaoImpl extends AbstractDao<Guest> implements IGuestDao {

    public GuestDaoImpl() {
        super(new Guest());
    }

    @Override
    public void setImportGuests(Session session, List<Guest> list) throws SQLException {
        for (Guest list1 : list) {
            session.saveOrUpdate(list1);
        }

    }

    @Override
    public Integer getIdByNumberOnlist(Session session, Integer number) throws SQLException {
        return getAll(session, SortName.zero.toString()).get(number).getId();
    }

}
