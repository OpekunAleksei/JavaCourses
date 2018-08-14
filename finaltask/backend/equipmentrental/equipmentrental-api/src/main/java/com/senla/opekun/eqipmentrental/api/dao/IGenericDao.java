package com.senla.opekun.eqipmentrental.api.dao;

import java.util.List;

/**
 * @author Алексей Опекун
 * @version 1.0
 * @param <T> описывает тип параметра
 */
public interface IGenericDao<T> {

    public void delete(Long id);

    public List<T> getAll();

    public T getById(Long id);

    public T update(T entity);

    public T save(T entity);

}
