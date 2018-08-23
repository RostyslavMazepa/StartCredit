package com.mysolutions.startcredit.service;

import com.mysolutions.startcredit.entity.Phone;

import java.util.List;

public interface IPhoneService {

    List<Phone> getPhoneAll();

    Phone getPhoneById(Long phoneId);

    Phone createPhone(Phone phone);

    void updatePhone(Phone phone);

    void deletePhone(Long phoneId);
}
