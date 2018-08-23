package com.mysolutions.startcredit.repository;

import com.mysolutions.startcredit.entity.RelationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRelationTypeRepository extends JpaRepository<RelationType, Long> {

}
