package com.senla.opekun.eqipmentrental.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import com.senla.opekun.eqipmentrental.api.dao.IProductDao;
import com.senla.opekun.eqipmentrental.model.Manufacturer;
import com.senla.opekun.eqipmentrental.model.Product;
import com.senla.opekun.eqipmentrental.model.ProductCategory;
import com.senla.opekun.eqipmentrental.model.Product_;
import javax.persistence.criteria.JoinType;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Repository
public class ProductDaoImpl extends AbstractDao<Product> implements IProductDao {

    public ProductDaoImpl() {
	super(Product.class);
    }

    @Override
    public List<Product> getProductsByCategory(ProductCategory productCategory) {
	CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
	CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
	Root<Product> root = criteriaQuery.from(Product.class);
	criteriaQuery.where(builder.equal(root.get(Product_.productCategory), productCategory));
	TypedQuery<Product> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
	return typedQuery.getResultList();
    }
    @Override
    public List<Product> getAll() {
	CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
	CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
	Root<Product> root = criteriaQuery.from(Product.class);
	root.fetch(Product_.productCategory, JoinType.INNER);
	TypedQuery<Product> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
	return typedQuery.getResultList();
    }
    public Product testJoin() {

	CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
	CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
	Root<Product> root = criteriaQuery.from(Product.class);
	root.fetch(Product_.manufacturer, JoinType.INNER);
	TypedQuery<Product> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
	return typedQuery.getResultList().get(0);
    }

    public Product getProductWithCharacteristics(Long id) {
	CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
	CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
	Root<Product> root = criteriaQuery.from(Product.class);
	root.fetch(Product_.productCharacteristic, JoinType.INNER);
	criteriaQuery.where(builder.equal(root.get(Product_.id), id));
	TypedQuery<Product> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
	return typedQuery.getResultList().get(0);
    }

    @Override
    public Manufacturer getManufacturerOfProduct(Product product) {
	CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
	CriteriaQuery<Manufacturer> criteriaQuery = builder.createQuery(Manufacturer.class);
	Root<Product> root = criteriaQuery.from(Product.class);
	criteriaQuery.select(root.get(Product_.manufacturer))
		.where(builder.equal(root.get(Product_.id), product.getId()));
	TypedQuery<Manufacturer> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
	return typedQuery.getResultList().get(0);
    }

    @Override
    public Product getProductByTitle(String title) {
	CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
	CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
	Root<Product> root = criteriaQuery.from(Product.class);
	criteriaQuery.where(builder.equal(root.get(Product_.title), title));
	TypedQuery<Product> typedQuery = super.getEntityManager().createQuery(criteriaQuery);
	if (!typedQuery.getResultList().isEmpty()) {
	    return typedQuery.getResultList().get(0);
	} else {
	    return null;
	}
    }

}
