package com.mysolutions.startcredit.controller;

import com.mysolutions.startcredit.entity.PhoneType;
import com.mysolutions.startcredit.service.IPhoneTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
public class PhoneTypeController {

    @Autowired
    private IPhoneTypeService phoneTypeService;

    @GetMapping("/phonetype")
    public ResponseEntity<PhoneType> getPhoneTypeById(@RequestParam("id") String id) {
        PhoneType phoneType = phoneTypeService.getPhoneTypeById(Long.parseLong(id));
        return new ResponseEntity<PhoneType>(phoneType, HttpStatus.OK);
    }

    @GetMapping("/phonetypes")
    public ResponseEntity<List<PhoneType>> getPhoneTypeAll() {
        List<PhoneType> phoneType = phoneTypeService.getPhoneTypeAll();
        return new ResponseEntity<List<PhoneType>>(phoneType, HttpStatus.OK);
    }

    @PostMapping("/phonetype")
    public ResponseEntity<Void> createPhoneType(@RequestBody PhoneType phoneType, UriComponentsBuilder builder) {
        //boolean flag = phoneTypeService.createPhoneType(phoneType);
        PhoneType phoneTypeSave = phoneTypeService.createPhoneType(phoneType);
        if (phoneTypeSave.toString().isEmpty()/*flag == false*/) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/phonetype?id={id}").buildAndExpand(phoneType.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/phonetype")
    public ResponseEntity<PhoneType> updatePhoneType(@RequestBody PhoneType phoneType) {
        phoneTypeService.updatePhoneType(phoneType);
        return new ResponseEntity<PhoneType>(phoneType, HttpStatus.OK);
    }

    @DeleteMapping("/phonetype")
    public ResponseEntity<Void> deletePhoneType(@RequestParam("id") String id) {
        phoneTypeService.deletePhoneType(Long.parseLong(id));
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
