package com.mysolutions.startcredit.service;

import com.mysolutions.startcredit.entity.Document;

import java.util.List;

public interface IDocumentService {

    List<Document> getDocumentAll();

    Document getDocumentById(Long documentId);

    List<Document> getDocumentAllByType(String documentType);

    boolean createDocument(Document document);

    void updateDocument(Document document);

    void deleteDocument(Long documentId);
}
