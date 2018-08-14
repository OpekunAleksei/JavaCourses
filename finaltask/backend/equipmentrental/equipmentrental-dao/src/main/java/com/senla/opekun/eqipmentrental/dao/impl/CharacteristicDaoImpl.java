package com.senla.opekun.eqipmentrental.dao.impl;

import com.senla.opekun.eqipmentrental.api.dao.ICharacteristicDao;
import com.senla.opekun.eqipmentrental.model.Characteristic;
import org.springframework.stereotype.Repository;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Repository
public class CharacteristicDaoImpl extends AbstractDao<Characteristic> implements ICharacteristicDao {

    public CharacteristicDaoImpl() {
        super(Characteristic.class);
    }

}
