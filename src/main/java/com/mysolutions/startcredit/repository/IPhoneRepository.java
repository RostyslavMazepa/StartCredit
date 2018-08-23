package com.mysolutions.startcredit.repository;

import com.mysolutions.startcredit.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhoneRepository extends JpaRepository<Phone, Long> {

}
