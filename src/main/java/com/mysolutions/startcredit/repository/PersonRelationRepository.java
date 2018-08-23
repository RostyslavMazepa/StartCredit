package com.mysolutions.startcredit.repository;

import com.mysolutions.startcredit.entity.PersonRelation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonRelationRepository implements IPersonRelationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PersonRelation> getPersonRelationAll() {
        String hql = "FROM PersonRelation as pr ORDER BY pr.id DESC";
        return (List<PersonRelation>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<PersonRelation> getPersonRelationByPersonId(Long personId) {
        String hql = "FROM PersonRelation as p " +
                "WHERE p.personId = :personId ";
        return (List<PersonRelation>) entityManager.createQuery(hql)
                    .setParameter("personId", personId)
                    .getResultList();
    }

    @Override
    public void createPersonRelation(PersonRelation personRelation) {
        entityManager.persist(personRelation);
    }

    @Override
    public PersonRelation getPersonRelationById(Long personRelationId) {
        return entityManager.find(PersonRelation.class, personRelationId);
    }

    @Override
    public void updatePersonRelation(PersonRelation personRelation) {
        PersonRelation p = getPersonRelationById(personRelation.getId());
        p.setId(personRelation.getPersonId());
        p.setPersonId(p.getPersonId());
        p.setPersonRelationId(personRelation.getPersonRelationId());
        p.setRelationTypeId(personRelation.getRelationTypeId());
        p.setCreateDate(personRelation.getCreateDate());
        entityManager.flush();
    }

    @Override
    public void deletePersonRelation(PersonRelation personRelation) {
        entityManager.remove(getPersonRelationById(personRelation.getId()));
    }

    @Override
    public boolean personRelationExists(Long personId, Long personRelationId, Long relationTypeId) {
        String hql = "FROM PersonRelation as p " +
                "WHERE p.personId = :personId " +
                "and p.personRelationId = :personRelationId " +
                "and p.relationTypeId = :relationTypeId ";
        int count = entityManager.createQuery(hql)
                .setParameter("personId", personId)
                .setParameter("personRelationId", personRelationId)
                .setParameter("relationTypeId", relationTypeId)
                .getResultList()
                .size();
        return count > 0 ? true : false;
    }
}
