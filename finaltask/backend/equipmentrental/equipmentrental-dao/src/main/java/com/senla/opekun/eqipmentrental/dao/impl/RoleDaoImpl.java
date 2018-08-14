package com.senla.opekun.eqipmentrental.dao.impl;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import com.senla.opekun.eqipmentrental.api.dao.IRoleDao;
import com.senla.opekun.eqipmentrental.model.Role;
import com.senla.opekun.eqipmentrental.model.Role_;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements IRoleDao {

    public RoleDaoImpl() {
        super(Role.class);
    }

    @Override
    public Role getRoleByName(String name) {
        CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Role> criteriaQuery = builder.createQuery(Role.class);
        Root<Role> root = criteriaQuery.from(Role.class);
        criteriaQuery.where(builder.equal(root.get(Role_.title), name));
        TypedQuery<Role> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
        return typedQuery.getResultList().get(0);
    }

}
