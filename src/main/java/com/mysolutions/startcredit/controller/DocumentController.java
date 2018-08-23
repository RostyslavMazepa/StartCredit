package com.mysolutions.startcredit.controller;

import com.mysolutions.startcredit.entity.Document;
import com.mysolutions.startcredit.service.IDocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
public class DocumentController {

    @Autowired
    private IDocumentService documentService;

    @GetMapping("/document")
    public ResponseEntity<Document> getDocumentById(@RequestParam("id") String id) {
        Document document = documentService.getDocumentById(Long.parseLong(id));
        return new ResponseEntity<Document>(document, HttpStatus.OK);
    }

    @GetMapping("/documents")
    public ResponseEntity<List<Document>> getDocumentAll() {
        List<Document> listDocument = documentService.getDocumentAll();
        return new ResponseEntity<List<Document>>(listDocument, HttpStatus.OK);
    }

    @GetMapping("/documentsbytype")
    public ResponseEntity<List<Document>> getDocumentAllByType(@RequestParam("document_type") String documentType) {
        List<Document> listDocument = documentService.getDocumentAllByType(documentType);
        return new ResponseEntity<List<Document>>(listDocument, HttpStatus.OK);
    }

    @PostMapping("/document")
    public ResponseEntity<Void> createDocument(@RequestBody Document document, UriComponentsBuilder builder) {
        boolean flag = documentService.createDocument(document);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/document?id={id}").buildAndExpand(document.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/document")
    public ResponseEntity<Document> updateDocument(@RequestBody Document document) {
        documentService.updateDocument(document);
        return new ResponseEntity<Document>(document, HttpStatus.OK);
    }

    @DeleteMapping("/document")
    public ResponseEntity<Void> deletePerson(@RequestParam("id") String id) {
        documentService.deleteDocument(Long.parseLong(id));
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
