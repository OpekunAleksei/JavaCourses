package com.senla.opekun.eqipmentrental.dao.impl;

import com.senla.opekun.eqipmentrental.api.dao.IAuditDao;
import com.senla.opekun.eqipmentrental.model.Audit;
import com.senla.opekun.eqipmentrental.model.Audit_;
import com.senla.opekun.eqipmentrental.model.User;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Repository
public class AuditDaoImpl extends AbstractDao<Audit> implements IAuditDao {

    public AuditDaoImpl() {
        super(Audit.class);
    }

    @Override
    public List<Audit> getAuditOfUser(User user) {
        CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Audit> criteriaQuery = builder.createQuery(Audit.class);
        Root<Audit> root = criteriaQuery.from(Audit.class);
        criteriaQuery.where(builder.equal(root.get(Audit_.user), user)).orderBy(builder.asc(root.get(Audit_.actionDate)));
        TypedQuery<Audit> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}
