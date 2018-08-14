package com.senla.opekun.eqipmentrental.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senla.opekun.eqipmentrental.api.dao.IManufacturerDao;
import com.senla.opekun.eqipmentrental.api.service.IManufacturerService;
import com.senla.opekun.eqipmentrental.model.Manufacturer;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Service
@Transactional(isolation=Isolation.SERIALIZABLE)
public class ManufacturerServiceImpl implements IManufacturerService {

    @Autowired
    private IManufacturerDao manufacturerDao;

    @Override
    public void deleteManufacturer(Long id) {
        this.manufacturerDao.delete(id);
    }

    @Override
    public Manufacturer createManufacturer(Manufacturer manufacturer) {
        return this.manufacturerDao.save(manufacturer);

    }

    @Override
    public Manufacturer updateManufacturer(Manufacturer manufacturer) {
        return this.manufacturerDao.update(manufacturer);
    }

    @Override
    public List<Manufacturer> getManufacturers() {
        return this.manufacturerDao.getAll();
    }
}
