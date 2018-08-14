package com.senla.opekun.eqipmentrental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.senla.opekun.eqipmentrental.api.dao.ICharacteristicDao;
import com.senla.opekun.eqipmentrental.api.service.ICharacteristicService;
import com.senla.opekun.eqipmentrental.model.Characteristic;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Service
@Transactional(isolation=Isolation.SERIALIZABLE)
public class CharacteristicServiceImpl implements ICharacteristicService {

    @Autowired
    private ICharacteristicDao characteristicDao;

    @Override
    public void deleteCharacteristic(Long id) {
        this.characteristicDao.delete(id);
    }

    @Override
    public Characteristic createCharacteristic(Characteristic characteristic) {
        return this.characteristicDao.save(characteristic);
    }

    @Override
    public Characteristic updateCharacteristic(Characteristic characteristic) {
        return this.characteristicDao.update(characteristic);
    }

    @Override
    public List<Characteristic> getCharacteristics() {
        return this.characteristicDao.getAll();
    }

}
