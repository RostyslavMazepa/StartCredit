package com.mysolutions.startcredit.repository;

import com.mysolutions.startcredit.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface IPersonRepository extends JpaRepository<Person, Long> {

    //List<Person> getPersonAll();

    //Person getPersonById(Long personId);

    //void createPerson(Person person);

    //void updatePerson(Person person);

    //void deletePerson(Long personId);

    //boolean personExists(String firstName, String middleName, String lastName, Date birthDate);
}
