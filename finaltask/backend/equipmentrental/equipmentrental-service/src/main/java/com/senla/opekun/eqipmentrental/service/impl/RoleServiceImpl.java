package com.senla.opekun.eqipmentrental.service.impl;

import com.senla.opekun.eqipmentrental.api.dao.IRoleDao;
import com.senla.opekun.eqipmentrental.api.service.IRoleService;
import com.senla.opekun.eqipmentrental.model.Role;
import java.util.List;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Service
@Transactional(isolation=Isolation.SERIALIZABLE)
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> getRoles() {
        return this.roleDao.getAll();
    }
}
