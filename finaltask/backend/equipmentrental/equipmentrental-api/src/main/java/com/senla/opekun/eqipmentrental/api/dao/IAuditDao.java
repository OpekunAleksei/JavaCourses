package com.senla.opekun.eqipmentrental.api.dao;

import com.senla.opekun.eqipmentrental.model.Audit;
import com.senla.opekun.eqipmentrental.model.User;
import java.util.List;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface IAuditDao extends IGenericDao<Audit> {

    public List<Audit> getAuditOfUser(User user);
}
