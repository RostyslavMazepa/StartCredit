package com.mysolutions.startcredit.service;

import com.mysolutions.startcredit.entity.DocumentType;

import java.util.List;

public interface IDocumentTypeService {

    List<DocumentType> getDocumentTypeAll();

    DocumentType getDocumentTypeById(Long documentTypeId);

    boolean createDocumentType(DocumentType documentType);

    void updateDocumentType(DocumentType documentType);

    void deleteDocumentType(Long documentTypeId);
}
