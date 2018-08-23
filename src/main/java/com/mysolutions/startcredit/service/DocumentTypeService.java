package com.mysolutions.startcredit.service;

import com.mysolutions.startcredit.repository.IDocumentTypeRepository;
import com.mysolutions.startcredit.entity.DocumentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeService implements IDocumentTypeService {

    @Autowired
    private IDocumentTypeRepository documentTypeRepository;

    @Override
    public List<DocumentType> getDocumentTypeAll() {
        return documentTypeRepository.getDocumentTypeAll();
    }

    @Override
    public DocumentType getDocumentTypeById(Long documentTypeId) {
        return documentTypeRepository.getDocumentTypeById(documentTypeId);
    }

    @Override
    public boolean createDocumentType(DocumentType documentType) {
        if (documentTypeRepository.documentTypeExists(documentType.getName())) {
            return false;
        } else {
            documentTypeRepository.createDocumentType(documentType);
            return true;
        }
    }

    @Override
    public void updateDocumentType(DocumentType documentType) {
        documentTypeRepository.updateDocumentType(documentType);
    }

    @Override
    public void deleteDocumentType(Long documentTypeId) {
        documentTypeRepository.deleteDocumentType(documentTypeId);
    }
}
