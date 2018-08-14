package com.senla.opekun.eqipmentrental.api.dao;

import com.senla.opekun.eqipmentrental.model.Role;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface IRoleDao extends IGenericDao<Role> {

    public Role getRoleByName(String name);
}
