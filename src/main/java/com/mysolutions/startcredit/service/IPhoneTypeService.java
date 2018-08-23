package com.mysolutions.startcredit.service;

import com.mysolutions.startcredit.entity.PhoneType;

import java.util.List;

public interface IPhoneTypeService {

    List<PhoneType> getPhoneTypeAll();

    PhoneType getPhoneTypeById(Long phoneTypeId);

    PhoneType createPhoneType(PhoneType phoneType);

    void updatePhoneType(PhoneType phoneType);

    void deletePhoneType(Long phoneTypeId);
}
