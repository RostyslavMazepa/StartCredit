package com.mysolutions.startcredit.repository;

import com.mysolutions.startcredit.entity.PhoneType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhoneTypeRepository extends JpaRepository<PhoneType, Long> {

}
