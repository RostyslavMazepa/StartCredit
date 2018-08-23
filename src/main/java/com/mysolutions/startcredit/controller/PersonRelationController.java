package com.mysolutions.startcredit.controller;

import com.mysolutions.startcredit.entity.PersonRelation;
import com.mysolutions.startcredit.service.IPersonRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class PersonRelationController {

    @Autowired
    private IPersonRelationService personRelationService;

    @GetMapping("/personrelation")
    public ResponseEntity<PersonRelation> getPersonRelationById(@RequestParam("id") String id) {
        PersonRelation personRelation = personRelationService.getPersonRelationById(Long.parseLong(id));
        return new ResponseEntity<PersonRelation>(personRelation, HttpStatus.OK);
    }

    @GetMapping("/personrelations")
    public ResponseEntity<List<PersonRelation>> getPersonRelationAll() {
        List<PersonRelation> personRelationList = personRelationService.getPersonRelationAll();
        return new ResponseEntity<List<PersonRelation>>(personRelationList, HttpStatus.OK);
    }

    @PostMapping("/personrelation")
    public ResponseEntity<PersonRelation> createPersonRelation(@RequestBody PersonRelation personRelation) {
        boolean flag = personRelationService.createPersonRelation(personRelation);
        if ( flag ) {
            return new ResponseEntity<PersonRelation>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<PersonRelation>(HttpStatus.CREATED);
    }

    @PutMapping("/personrelation")
    public ResponseEntity<PersonRelation> updatePersonRelation(@RequestBody PersonRelation personRelation) {
        personRelationService.updatePersonRelation(personRelation);
        return new ResponseEntity<PersonRelation>(personRelation, HttpStatus.OK);
    }

    @DeleteMapping("/personrelation")
    public ResponseEntity<Void> deletePersonRelation(@RequestBody PersonRelation personRelation) {
        personRelationService.deletePersonRelation(personRelation);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
