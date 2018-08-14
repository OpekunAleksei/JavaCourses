package com.senla.opekun.eqipmentrental.api.service;

import com.senla.opekun.eqipmentrental.model.Manufacturer;
import java.util.List;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface IManufacturerService {

    public void deleteManufacturer(Long id);

    public Manufacturer createManufacturer(Manufacturer manufacturer);

    public Manufacturer updateManufacturer(Manufacturer manufacturer);

    public List<Manufacturer> getManufacturers();
}
