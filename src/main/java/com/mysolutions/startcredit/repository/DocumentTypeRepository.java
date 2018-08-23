package com.mysolutions.startcredit.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import com.mysolutions.startcredit.entity.DocumentType;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentTypeRepository implements IDocumentTypeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<DocumentType> getDocumentTypeAll() {
        String hql = "FROM DocumentType as d ORDER BY d.id DESC";
        return (List<DocumentType>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public DocumentType getDocumentTypeById(Long documentTypeId) {
        return entityManager.find(DocumentType.class, documentTypeId);
    }

    @Override
    public void createDocumentType(DocumentType documentType) {
        entityManager.persist(documentType);
    }

    @Override
    public void updateDocumentType(DocumentType documentType) {
        DocumentType dft = getDocumentTypeById(documentType.getId());
        dft.setName(documentType.getName());
        dft.setEnable(documentType.getEnable());
        entityManager.flush();
    }

    @Override
    public void deleteDocumentType(Long documentTypeId) {
        entityManager.remove(getDocumentTypeById(documentTypeId));
    }

    @Override
    public boolean documentTypeExists(String documentTypeName) {
        String hql = "FROM DocumentType as d WHERE d.name = :name";
        int count = entityManager.createQuery(hql)
                .setParameter("name", documentTypeName)
                .getResultList()
                .size();
        return count > 0 ? true : false;
    }
}
