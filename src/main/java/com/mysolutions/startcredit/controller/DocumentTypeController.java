package com.mysolutions.startcredit.controller;

import com.mysolutions.startcredit.entity.DocumentType;
import com.mysolutions.startcredit.service.IDocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
//import java.util.logging.Logger;

@Controller
public class DocumentTypeController {

    //@PersistenceContext
    //private Logger logger;

    @Autowired
    private IDocumentTypeService documentTypeService;

    @GetMapping("/documenttype")
    public ResponseEntity<DocumentType> getDocumentTypeById(@RequestParam("id") String id) {
        DocumentType documentType = documentTypeService.getDocumentTypeById(Long.parseLong(id));
        return new ResponseEntity<DocumentType>(documentType, HttpStatus.OK);
    }

    @GetMapping("/documenttypes")
    public ResponseEntity<List<DocumentType>> getDocumentTypeAll() {
        List<DocumentType> list = documentTypeService.getDocumentTypeAll();
        return new ResponseEntity<List<DocumentType>>(list, HttpStatus.OK);
    }

    @PostMapping("/documenttype")
    public ResponseEntity<Void> createDocumentType(@RequestBody DocumentType documentType, UriComponentsBuilder builder) {
        boolean flag = documentTypeService.createDocumentType(documentType);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/documenttype?id={id}").buildAndExpand(documentType.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/documenttype")
    public ResponseEntity<DocumentType> updateDocumentType(@RequestBody DocumentType documentType) {
        documentTypeService.updateDocumentType(documentType);
        return new ResponseEntity<DocumentType>(documentType, HttpStatus.OK);
    }

    @DeleteMapping("/documenttype")
    public ResponseEntity<Void> deleteDocumentType(@RequestParam("id") String id) {
        documentTypeService.deleteDocumentType(Long.parseLong(id));
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
