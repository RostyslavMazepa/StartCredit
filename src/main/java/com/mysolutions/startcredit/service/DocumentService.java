package com.mysolutions.startcredit.service;

import com.mysolutions.startcredit.repository.IDocumentRepository;
import com.mysolutions.startcredit.entity.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService implements IDocumentService {

    @Autowired
    private IDocumentRepository documentRepository;

    @Override
    public List<Document> getDocumentAll() {
        return documentRepository.getDocumentAll();
    }

    @Override
    public Document getDocumentById(Long documentId) {
        return documentRepository.getDocumentById(documentId);
    }

    @Override
    public List<Document> getDocumentAllByType(String documentType) {
        return documentRepository.getDocumentAllByType(documentType);
    }

    @Override
    public boolean createDocument(Document document) {
        if (documentRepository.personExists(
                document.getSeriesDocument(),
                document.getNumberDocument(),
                document.getPersonId())) {
            return false;
        } else {
            documentRepository.createDocument(document);
            return true;
        }
    }

    @Override
    public void updateDocument(Document document) {
        documentRepository.updateDocument(document);
    }

    @Override
    public void deleteDocument(Long documentId) {
        documentRepository.deleteDocument(documentId);
    }
}
