package com.mysolutions.startcredit.service;

import com.mysolutions.startcredit.entity.Person;

import java.util.List;

public interface IPersonService {

    List<Person> getPersonAll();

    Person getPersonById(Long personId);

    Person createPerson(Person person);

    void updatePerson(Person person);

    void deletePerson(Long personId);
}
