package com.mysolutions.startcredit.service;

import com.mysolutions.startcredit.entity.Phone;
import com.mysolutions.startcredit.repository.IPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService implements IPhoneService {

    @Autowired
    private IPhoneRepository phoneRepository;

    @Override
    public List<Phone> getPhoneAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone getPhoneById(Long phoneId) {
        return phoneRepository.getOne(phoneId);
    }

    @Override
    public Phone createPhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public void updatePhone(Phone phone) {
        phoneRepository.save(phone);
    }

    @Override
    public void deletePhone(Long phoneId) {
        phoneRepository.deleteById(phoneId);
    }
}
