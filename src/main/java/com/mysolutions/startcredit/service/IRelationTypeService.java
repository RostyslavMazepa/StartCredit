package com.mysolutions.startcredit.service;

import com.mysolutions.startcredit.entity.RelationType;

import java.util.List;

public interface IRelationTypeService {

    List<RelationType> getRelationTypeAll();

    RelationType getRelationTypeById(Long relationTypeId);

    RelationType createRelationType(RelationType relationType);

    void updateRelationType(RelationType relationType);

    void deleteRelationType(Long relationTypeId);
}
