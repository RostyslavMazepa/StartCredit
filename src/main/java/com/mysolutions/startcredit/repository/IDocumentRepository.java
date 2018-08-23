package com.mysolutions.startcredit.repository;

import com.mysolutions.startcredit.entity.Document;

import java.util.List;

public interface IDocumentRepository {

    List<Document> getDocumentAll();

    Document getDocumentById(Long documentId);

    List<Document> getDocumentAllByType(String documentType);

    void createDocument(Document document);

    void updateDocument(Document document);

    void deleteDocument(Long documentId);

    boolean personExists(String seriesDocument, String numberDocument, Long personId);
}
