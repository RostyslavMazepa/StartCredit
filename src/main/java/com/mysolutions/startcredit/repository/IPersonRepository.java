package com.mysolutions.startcredit.repository;

import com.mysolutions.startcredit.entity.Person;

import java.sql.Date;
import java.util.List;

public interface IPersonRepository {

    List<Person> getPersonAll();

    Person getPersonById(Long personId);

    void createPerson(Person person);

    void updatePerson(Person person);

    void deletePerson(Long personId);

    boolean personExists(String firstName, String middleName, String lastName, Date birthDate);
}
