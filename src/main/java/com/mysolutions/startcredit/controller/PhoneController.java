package com.mysolutions.startcredit.controller;

import com.mysolutions.startcredit.entity.Phone;
import com.mysolutions.startcredit.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
public class PhoneController {

    @Autowired
    private IPhoneService phoneService;

    @GetMapping("/phone")
    public ResponseEntity<Phone> getPhoneById(@RequestParam("id") String id) {
        Phone phoneType = phoneService.getPhoneById(Long.parseLong(id));
        return new ResponseEntity<Phone>(phoneType, HttpStatus.OK);
    }

    @GetMapping("/phones")
    public ResponseEntity<List<Phone>> getPhoneAll() {
        List<Phone> phone = phoneService.getPhoneAll();
        return new ResponseEntity<List<Phone>>(phone, HttpStatus.OK);
    }

    @PostMapping("/phone")
    public ResponseEntity<Void> createPhoneType(@RequestBody Phone phone, UriComponentsBuilder builder) {
        //boolean flag = phoneTypeService.createPhoneType(phoneType);
        Phone phoneSave = phoneService.createPhone(phone);
        if (phoneSave.toString().isEmpty()/*flag == false*/) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/phone?id={id}").buildAndExpand(phone.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/phone")
    public ResponseEntity<Phone> updatePhone(@RequestBody Phone phone) {
        phoneService.updatePhone(phone);
        return new ResponseEntity<Phone>(phone, HttpStatus.OK);
    }

    @DeleteMapping("/phone")
    public ResponseEntity<Void> deletePhone(@RequestParam("id") String id) {
        phoneService.deletePhone(Long.parseLong(id));
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
