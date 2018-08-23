package com.mysolutions.startcredit.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Objects;


@Entity
@Table(name = "document")
public class Document {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "document_type_id")
    private Long documentTypeId;

    @JoinColumn(name = "document_type_id", updatable = false, insertable = false)
    @ManyToOne(targetEntity = DocumentType.class, fetch = FetchType.EAGER)
    private DocumentType documentType;

    @NotNull
    @Column(name = "person_id")
    private Long personId;

    @JoinColumn(name = "person_id", updatable = false, insertable = false)
    @ManyToOne(targetEntity = Person.class, fetch = FetchType.EAGER)
    private Person person;

    @NotNull
    @Column(name = "issue_date")
    private Date issueDate;

    @NotNull
    @Column(name = "issue_by")
    private String issueBy;

    @Column(name = "series_document")
    private String seriesDocument;

    @NotNull
    @Column(name = "number_document")
    private String numberDocument;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Long documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssueBy() {
        return issueBy;
    }

    public void setIssueBy(String issueBy) {
        this.issueBy = issueBy;
    }

    public String getSeriesDocument() {
        return seriesDocument;
    }

    public void setSeriesDocument(String seriesDocument) {
        this.seriesDocument = seriesDocument;
    }

    public String getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(String numberDocument) {
        this.numberDocument = numberDocument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return id == document.id &&
                documentTypeId == document.documentTypeId &&
                personId == document.personId &&
                Objects.equals(documentType, document.documentType) &&
                Objects.equals(person, document.person) &&
                Objects.equals(issueDate, document.issueDate) &&
                Objects.equals(issueBy, document.issueBy) &&
                Objects.equals(seriesDocument, document.seriesDocument) &&
                Objects.equals(numberDocument, document.numberDocument);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, documentTypeId, documentType, personId, person, issueDate, issueBy, seriesDocument, numberDocument);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", documentTypeId=" + documentTypeId +
                ", documentType=" + documentType +
                ", personId=" + personId +
                ", person=" + person +
                ", issueDate=" + issueDate +
                ", issueBy=" + issueBy +
                ", seriesDocument='" + seriesDocument + '\'' +
                ", numberDocument='" + numberDocument + '\'' +
                '}';
    }
}