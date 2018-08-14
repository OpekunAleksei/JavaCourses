package com.senla.opekun.eqipmentrental.api.service;

import com.senla.opekun.eqipmentrental.model.Person;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface IPersonService {

    public Person createPerson(Person person);

    public Person updatePerson(Person person);
}
