/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.dao;

import com.senla.hotel.entity.Entity;
import java.util.List;


public interface IGenericDao<T extends Entity> {

    public List<T> getAll();

    public T getByID(Integer id);

    public void update(T entity);

    public void create(T entity);



}
