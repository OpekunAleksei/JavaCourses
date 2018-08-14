package com.senla.opekun.eqipmentrental.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senla.opekun.eqipmentrental.api.dao.IPersonDao;
import com.senla.opekun.eqipmentrental.api.service.IPersonService;
import com.senla.opekun.eqipmentrental.model.Person;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Service
@Transactional(isolation=Isolation.SERIALIZABLE)
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonDao personDao;

    @Override
    public Person createPerson(Person person) {
        return this.personDao.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return this.personDao.update(person);
    }
}
