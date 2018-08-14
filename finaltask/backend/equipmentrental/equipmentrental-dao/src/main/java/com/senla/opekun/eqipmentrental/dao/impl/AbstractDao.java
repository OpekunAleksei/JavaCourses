package com.senla.opekun.eqipmentrental.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import com.senla.opekun.eqipmentrental.api.dao.IGenericDao;
import com.senla.opekun.eqipmentrental.model.generic.Model;

/**
 * @author Алексей Опекун
 * @version 1.0
 * @param <T>
 *            описывает тип параметра
 */
@Repository
public abstract class AbstractDao<T extends Model> implements IGenericDao<T> {

    private final Class<T> clazz;
    @PersistenceContext
    private EntityManager entityManager;

    protected final EntityManager getEntityManager() {

	return entityManager;
    }

    public AbstractDao(Class<T> clazz) {

	this.clazz = clazz;
    }

    @Override
    public void delete(Long id) {
	entityManager.remove(getById(id));
    }

    @Override
    public T getById(Long id) {
	return entityManager.find(clazz, id);
    }

    @Override
    public T save(T entity) {
	entityManager.persist(entity);
	return entity;
    }

    @Override
    public T update(T entity) {
	return entityManager.merge(entity);
    }

    @Override
    public List<T> getAll() {
	CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	CriteriaQuery<T> criteriaQuery = builder.createQuery(this.clazz);
	Root<T> root = criteriaQuery.from(this.clazz);
	criteriaQuery.select(root);
	TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);
	return typedQuery.getResultList();
    }
}
