package com.mysolutions.startcredit.service;

import com.mysolutions.startcredit.entity.RelationType;
import com.mysolutions.startcredit.repository.IRelationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationTypeService implements IRelationTypeService {

    @Autowired
    private IRelationTypeRepository relationTypeRepository;

    @Override
    public List<RelationType> getRelationTypeAll() {
        return relationTypeRepository.findAll();
    }

    @Override
    public RelationType getRelationTypeById(Long relationTypeId) {
        return relationTypeRepository.getOne(relationTypeId);
    }

    @Override
    public RelationType createRelationType(RelationType relationType) {
        return relationTypeRepository.save(relationType);
    }

    @Override
    public void updateRelationType(RelationType relationType) {
        relationTypeRepository.save(relationType);
    }

    @Override
    public void deleteRelationType(Long relationTypeId) {
        relationTypeRepository.deleteById(relationTypeId);
    }
}
