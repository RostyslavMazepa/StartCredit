package com.mysolutions.startcredit.repository;

import com.mysolutions.startcredit.entity.DocumentType;

import java.util.List;

public interface IDocumentTypeRepository {

    List<DocumentType> getDocumentTypeAll();

    DocumentType getDocumentTypeById(Long documentTypeId);

    void createDocumentType(DocumentType documentType);

    void updateDocumentType(DocumentType documentType);

    void deleteDocumentType(Long documentTypeId);

    boolean documentTypeExists(String documentTypeName);
}
