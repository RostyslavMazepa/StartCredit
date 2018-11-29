package com.mysolutions.startcredit.repository;

import com.mysolutions.startcredit.entity.Document;
import com.mysolutions.startcredit.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 @Repository
 public interface IDocumentRepository extends JpaRepository<Document, Long> {

 @Query("SELECT r FROM ObjectsInApplicationToLease r " +
 "WHERE r.objectInApplication.guid = :accountingItemGuid ")
 List<ObjectsInApplicationToLease> findObjectsInApplicationToLeaseByAccountingItemGuid(@Param("accountingItemGuid") UUID guid);
 }
 */


@Repository
public class DocumentRepository implements IDocumentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Document> getDocumentAll() {
        String hql = "FROM Document as d ORDER BY d.id DESC";
        return (List<Document>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Document getDocumentById(Long documentId) {
        return entityManager.find(Document.class, documentId);
    }

    @Override
    public List<Document> getDocumentAllByType(String documentType) {
        String hql = "SELECT d FROM Document as d, " +
                "DocumentType as t " +
                "WHERE d.documentTypeId = t.id " +
                "AND t.name = :documentType " +
                "ORDER BY d.id DESC";
        return (List<Document>) entityManager.createQuery(hql)
                .setParameter("documentType", documentType)
                .getResultList();
    }

    @Override
    public void createDocument(Document document) {
        entityManager.persist(document);
    }

    @Override
    public void updateDocument(Document document) {
        Document d = getDocumentById(document.getId());
        d.setPersonId(document.getPersonId());
        d.setDocumentTypeId(document.getDocumentTypeId());
        d.setIssueBy(document.getIssueBy());
        d.setIssueDate(document.getIssueDate());
        d.setNumberDocument(document.getNumberDocument());
        d.setSeriesDocument(document.getSeriesDocument());
        entityManager.flush();
    }

    @Override
    public void deleteDocument(Long documentId) {
        entityManager.remove(getDocumentById(documentId));
    }

    @Override
    public boolean personExists(String seriesDocument, String numberDocument, Long personId) {
        String hql = "FROM Document as d " +
                "WHERE d.seriesDocument = :seriesDocument " +
                "and d.numberDocument = :numberDocument " +
                "and d.personId = :personId ";
        int count = entityManager.createQuery(hql)
                .setParameter("seriesDocument", seriesDocument)
                .setParameter("numberDocument", numberDocument)
                .setParameter("personId", personId)
                .getResultList()
                .size();
        return count > 0 ? true : false;
    }
}
