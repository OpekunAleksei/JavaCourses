package com.senla.opekun.eqipmentrental.dao.impl;

import com.senla.opekun.eqipmentrental.api.dao.IManufacturerDao;
import com.senla.opekun.eqipmentrental.model.Manufacturer;
import org.springframework.stereotype.Repository;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Repository
public class ManufacturerDaoImpl extends AbstractDao<Manufacturer> implements IManufacturerDao {

    public ManufacturerDaoImpl() {
        super(Manufacturer.class);
    }

}
