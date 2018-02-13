/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.dao;

import com.senla.hotel.entity.Guest;
import java.util.List;

/**
 *
 * @author user
 */
public interface IGuestDao extends IGenericDao<Guest>{

    public void setImportGuests(List<Guest> list);

    public Integer getIdByNumberOnlist(Integer number);

    public List<Guest> getSortingList(String name);

  
    
}
