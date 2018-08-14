package com.senla.opekun.eqipmentrental.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import com.senla.opekun.eqipmentrental.api.dao.IUserDao;
import com.senla.opekun.eqipmentrental.model.History;
import com.senla.opekun.eqipmentrental.model.History_;
import com.senla.opekun.eqipmentrental.model.Person;
import com.senla.opekun.eqipmentrental.model.Product;
import com.senla.opekun.eqipmentrental.model.Product_;
import com.senla.opekun.eqipmentrental.model.Role;
import com.senla.opekun.eqipmentrental.model.User;
import com.senla.opekun.eqipmentrental.model.User_;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Repository
public class UserDaoImpl extends AbstractDao<User> implements IUserDao {

    public UserDaoImpl() {

        super(User.class);
    }

    @Override
    public List<User> getDebtorUsers() {

        CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<History> root = criteriaQuery.from(History.class);
        Join<History, User> users = root.join(History_.user);
        ParameterExpression<Date> dateOfReceivingParameter = builder.parameter(Date.class);
        Path<Date> checkDateOfReceiving = root.<Date>get(History_.dateOfReceiving);
        Predicate dateOfReceivingPredicate = builder.lessThan(checkDateOfReceiving, dateOfReceivingParameter);
        criteriaQuery.select(users)
                .where(builder.and(builder.equal(root.get(History_.enable), false), dateOfReceivingPredicate))
                .distinct(true);
        TypedQuery<User> typedQuery = super.getEntityManager().createQuery(criteriaQuery)
                .setParameter(dateOfReceivingParameter, new Date(), TemporalType.DATE);
        return typedQuery.getResultList();
    }

    @Override
    public List<User> getUsersByRole(Role role) {
        CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.where(builder.equal(root.get(User_.role), role));
        TypedQuery<User> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public User getUserWithPerson(Long id) {
        CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        root.fetch(User_.person, JoinType.INNER);
        criteriaQuery.where(builder.equal(root.get(User_.id), id));
        TypedQuery<User> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
        return typedQuery.getResultList().get(0);
    }

    @Override
    public User getUserByNickname(String nickname) {
        CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.where(builder.equal(root.get(User_.nickname), nickname));
        TypedQuery<User> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
        if (!typedQuery.getResultList().isEmpty()) {
            return typedQuery.getResultList().get(0);
        } else {
            return null;
        }
    }

    @Override
    public User getUserByLogin(String login) {
        CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.where(builder.equal(root.get(User_.login), login));
        TypedQuery<User> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
        if (!typedQuery.getResultList().isEmpty()) {
            return typedQuery.getResultList().get(0);
        } else {
            return null;
        }
    }

}
