package com.senla.opekun.eqipmentrental.dao.impl;

import com.senla.opekun.eqipmentrental.api.dao.IPersonDao;
import com.senla.opekun.eqipmentrental.model.Person;
import org.springframework.stereotype.Repository;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Repository
public class PersonDaoImpl extends AbstractDao<Person> implements IPersonDao {

    public PersonDaoImpl() {
        super(Person.class);
    }
}
