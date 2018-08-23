package com.mysolutions.startcredit.service;

import com.mysolutions.startcredit.entity.PersonRelation;
import com.mysolutions.startcredit.repository.IPersonRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonRelationService implements IPersonRelationService {

    @Autowired
    private IPersonRelationRepository personRelationRepository;

    @Override
    public List<PersonRelation> getPersonRelationAll() {
        return personRelationRepository.getPersonRelationAll();
    }

    @Override
    public PersonRelation getPersonRelationById(Long personRelationId) {
        return personRelationRepository.getPersonRelationById(personRelationId);
    }

    @Override
    public List<PersonRelation> getPersonRelationByPersonId(Long personId) {
        return personRelationRepository.getPersonRelationByPersonId(personId);
    }

    @Override
    public boolean createPersonRelation(PersonRelation personRelation) {
        if (personRelationRepository.personRelationExists(
                personRelation.getPersonId(),
                personRelation.getPersonRelationId(),
                personRelation.getRelationTypeId())) {
            return false;
        } else {
            personRelationRepository.createPersonRelation(personRelation);
            return true;
        }
    }

    @Override
    public void updatePersonRelation(PersonRelation personRelation) {
        personRelationRepository.updatePersonRelation(personRelation);
    }

    @Override
    public void deletePersonRelation(PersonRelation personRelation) {
        personRelationRepository.deletePersonRelation(personRelation);
    }

    @Override
    public boolean personRelationExists(Long personId, Long personRelationId, Long relationTypeId) {
        return personRelationRepository.personRelationExists(personId, personRelationId, relationTypeId);
    }
}
