package com.mysolutions.startcredit.repository;

import com.mysolutions.startcredit.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.util.List;


@Repository
public class PersonRepository implements IPersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> getPersonAll() {
        String hql = "FROM Person as p ORDER BY p.id DESC";
        return (List<Person>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Person getPersonById(Long personId) {
        return entityManager.find(Person.class, personId);
    }

    @Override
    public void createPerson(Person person) {
        entityManager.persist(person);
    }

    @Override
    public void updatePerson(Person person) {
        Person p = getPersonById(person.getId());
        p.setBirthDate(person.getBirthDate());
        p.setFirstName(person.getFirstName());
        p.setLastName(person.getLastName());
        p.setMiddleName(person.getMiddleName());
        p.setSex(person.getSex());
        entityManager.flush();
    }

    @Override
    public void deletePerson(Long personId) {
        entityManager.remove(getPersonById(personId));
    }

    @Override
    public boolean personExists(String firstName, String middleName, String lastName, Date birthDate) {
        String hql = "FROM Person as p WHERE p.firstName = :firstName " +
                "and p.middleName = :middleName " +
                "and p.lastName = :lastName " +
                "and p.birthDate = :birthDate";
        int count = entityManager.createQuery(hql)
                .setParameter("firstName", firstName)
                .setParameter("middleName", middleName)
                .setParameter("lastName", lastName)
                .setParameter("birthDate", birthDate)
                .getResultList()
                .size();
        return count > 0 ? true : false;
    }
}
