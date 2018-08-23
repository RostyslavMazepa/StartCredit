package com.mysolutions.startcredit.service;

import com.mysolutions.startcredit.repository.IPersonRepository;
import com.mysolutions.startcredit.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private IPersonRepository personRepository;

    @Override
    public List<Person> getPersonAll() {
        return personRepository.getPersonAll();
    }

    @Override
    public Person getPersonById(Long personId) {
        return personRepository.getPersonById(personId);
    }

    @Override
    public boolean createPerson(Person person) {
        if (personRepository.personExists(
                person.getFirstName(),
                person.getMiddleName(),
                person.getLastName(),
                person.getBirthDate())) {
            return false;
        } else {
            personRepository.createPerson(person);
            return true;
        }
    }

    @Override
    public void updatePerson(Person person) {
        personRepository.updatePerson(person);
    }

    @Override
    public void deletePerson(Long personId) {
        personRepository.deletePerson(personId);
    }
}
