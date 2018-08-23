package com.mysolutions.startcredit.service;

import com.mysolutions.startcredit.entity.PersonRelation;

import java.util.List;

public interface IPersonRelationService {

    List<PersonRelation> getPersonRelationAll();

    PersonRelation getPersonRelationById(Long personRelationId);

    List<PersonRelation> getPersonRelationByPersonId(Long personId);

    boolean createPersonRelation(PersonRelation personRelation);

    void updatePersonRelation(PersonRelation personRelation);

    void deletePersonRelation(PersonRelation personRelation);

    boolean personRelationExists(Long personId, Long personRelationId, Long relationTypeId);
}
