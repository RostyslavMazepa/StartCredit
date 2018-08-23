package com.mysolutions.startcredit.controller;

import com.mysolutions.startcredit.entity.Person;
import com.mysolutions.startcredit.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private IPersonService personService;

    @GetMapping("/person")
    public ResponseEntity<Person> getPersonById(@RequestParam("id") String id) {
        Person person = personService.getPersonById(Long.parseLong(id));
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getPersonAll() {
        List<Person> listPerson = personService.getPersonAll();
        return new ResponseEntity<List<Person>>(listPerson, HttpStatus.OK);
    }

    @PostMapping("/person")
    public ResponseEntity<Void> createPerson(@RequestBody Person person, UriComponentsBuilder builder) {
        boolean flag = personService.createPerson(person);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/person?id={id}").buildAndExpand(person.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/person")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        personService.updatePerson(person);
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    @DeleteMapping("/person")
    public ResponseEntity<Void> deletePerson(@RequestParam("id") String id) {
        personService.deletePerson(Long.parseLong(id));
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
