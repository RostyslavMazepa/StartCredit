package com.mysolutions.startcredit.controller;

import com.mysolutions.startcredit.entity.RelationType;
import com.mysolutions.startcredit.service.IRelationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
public class RelationTypeController {
    @Autowired
    IRelationTypeService relationTypeService;

    @GetMapping("/relationtype")
    public ResponseEntity<RelationType> getRelationTypeById(@RequestParam("id") String id) {
        RelationType relationType = relationTypeService.getRelationTypeById(Long.parseLong(id));
        return new ResponseEntity<RelationType>(relationType, HttpStatus.OK);
    }

    @GetMapping("/relationtypes")
    public ResponseEntity<List<RelationType>> getRelationTypeAll() {
        List<RelationType> relationTypeList = relationTypeService.getRelationTypeAll();
        return new ResponseEntity<List<RelationType>>(relationTypeList, HttpStatus.OK);
    }
    /*
    @PostMapping("/relationtype")
    public ResponseEntity<Void> createRelationType(@RequestBody RelationType relationType, UriComponentsBuilder builder) {
        RelationType relationTypeSave = relationTypeService.createRelationType(relationType);
        if (relationTypeSave.toString().isEmpty()) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/relationtype?id={id}").buildAndExpand(relationTypeSave.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    */

    @PostMapping("/relationtype")
    public ResponseEntity<RelationType> createRelationType(@RequestBody RelationType relationType) {
        RelationType relationTypeNew = relationTypeService.createRelationType(relationType);
        if (relationTypeNew.toString().isEmpty()) {
            return new ResponseEntity<RelationType>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<RelationType>(relationTypeNew, HttpStatus.CREATED);
    }

    @PutMapping("/relationtype")
    public ResponseEntity<RelationType> updateRelationType(@RequestBody RelationType relationType) {
        relationTypeService.updateRelationType(relationType);
        return new ResponseEntity<RelationType>(relationType, HttpStatus.OK);
    }

    @DeleteMapping("/relationtype")
    public ResponseEntity<Void> deleteRelationType(@RequestParam("id") String id) {
        relationTypeService.deleteRelationType(Long.parseLong(id));
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
