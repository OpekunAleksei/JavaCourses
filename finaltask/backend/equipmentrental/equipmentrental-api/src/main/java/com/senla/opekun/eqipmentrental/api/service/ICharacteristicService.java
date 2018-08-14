package com.senla.opekun.eqipmentrental.api.service;

import com.senla.opekun.eqipmentrental.model.Characteristic;
import java.util.List;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface ICharacteristicService {

    public void deleteCharacteristic(Long id);

    public Characteristic createCharacteristic(Characteristic characteristic);

    public Characteristic updateCharacteristic(Characteristic characteristic);

    public List<Characteristic> getCharacteristics();
}
