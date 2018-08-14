package com.senla.opekun.eqipmentrental.dao.impl;

import com.senla.opekun.eqipmentrental.api.dao.IHistoryDao;
import com.senla.opekun.eqipmentrental.model.History;
import com.senla.opekun.eqipmentrental.model.History_;
import com.senla.opekun.eqipmentrental.model.Product;
import com.senla.opekun.eqipmentrental.model.User;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Repository
public class HistoryDaoImpl extends AbstractDao<History> implements IHistoryDao {

    public HistoryDaoImpl() {
        super(History.class);
    }

    @Override
    public List<Product> getProductsOfUser(User user) {
        CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
        Root<History> root = criteriaQuery.from(History.class);
        Join<History, Product> products = root.join(History_.product);
        criteriaQuery.select(products).where(builder.and(builder.equal(root.get(History_.user), user), builder.equal(root.get(History_.enable), false)));
        TypedQuery<Product> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public History getHistoryByProduct(Product product) {
        CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<History> criteriaQuery = builder.createQuery(History.class);
        Root<History> root = criteriaQuery.from(History.class);
        criteriaQuery.where(builder.and(builder.equal(root.get(History_.product), product), builder.equal(root.get(History_.enable), false)));
        TypedQuery<History> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
        return typedQuery.getResultList().get(0);
    }

    @Override
    public List<History> getHistorysOfProduct(Product product) {
        CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<History> criteriaQuery = builder.createQuery(History.class);
        Root<History> root = criteriaQuery.from(History.class);
        criteriaQuery.where(builder.equal(root.get(History_.product), product)).groupBy(root.get(History_.dateOfReceiving));
        TypedQuery<History> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

}
