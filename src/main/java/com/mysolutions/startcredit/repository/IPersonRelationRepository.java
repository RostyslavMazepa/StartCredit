package com.mysolutions.startcredit.repository;

import com.mysolutions.startcredit.entity.PersonRelation;

import java.util.List;

public interface IPersonRelationRepository {

    List<PersonRelation> getPersonRelationAll();

    PersonRelation getPersonRelationById(Long personRelationId);

    List<PersonRelation> getPersonRelationByPersonId(Long personId);

    void createPersonRelation(PersonRelation personRelation);

    void updatePersonRelation(PersonRelation personRelation);

    void deletePersonRelation(PersonRelation personRelation);

    boolean personRelationExists(Long personId, Long personRelationId, Long relationTypeId);
}
