package com.senla.opekun.eqipmentrental.dao.impl;

import com.senla.opekun.eqipmentrental.api.dao.IProductCharacteristicDao;
import com.senla.opekun.eqipmentrental.model.ProductCharacteristic;
import org.springframework.stereotype.Repository;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Repository
public class ProductCharacteristicDaoImpl extends AbstractDao<ProductCharacteristic> implements IProductCharacteristicDao {

    public ProductCharacteristicDaoImpl() {
        super(ProductCharacteristic.class);
    }
}
