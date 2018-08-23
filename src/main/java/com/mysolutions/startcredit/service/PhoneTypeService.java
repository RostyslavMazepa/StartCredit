package com.mysolutions.startcredit.service;

import com.mysolutions.startcredit.entity.PhoneType;
import com.mysolutions.startcredit.repository.IPhoneTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneTypeService implements IPhoneTypeService {

    @Autowired
    private IPhoneTypeRepository phoneTypeRepository;

    @Override
    public List<PhoneType> getPhoneTypeAll() {
        return phoneTypeRepository.findAll();
    }

    @Override
    public PhoneType getPhoneTypeById(Long phoneTypeId) {
        return phoneTypeRepository.getOne(phoneTypeId);
    }

    @Override
    public PhoneType createPhoneType(PhoneType phoneType) {
        return phoneTypeRepository.save(phoneType);
    }

    @Override
    public void updatePhoneType(PhoneType phoneType) {
        phoneTypeRepository.save(phoneType);
    }

    @Override
    public void deletePhoneType(Long phoneTypeId) {
        phoneTypeRepository.deleteById(phoneTypeId);
    }
}
