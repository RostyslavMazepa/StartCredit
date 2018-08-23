package com.mysolutions.startcredit.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
public class PersonRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "person_id")
    private Long personId;

    @JoinColumn(name = "person_id", updatable = false, insertable = false)
    @ManyToOne(targetEntity = Person.class, fetch = FetchType.EAGER)
    private Person person;

    @NotNull
    @Column(name = "person_relation_id")
    private Long personRelationId;

    @JoinColumn(name = "person_relation_id", updatable = false, insertable = false)
    @ManyToOne(targetEntity = Person.class, fetch = FetchType.EAGER)
    private Person personRelation;

    @NotNull
    @Column(name = "relation_type_id")
    private Long relationTypeId;

    @JoinColumn(name = "relation_type_id", updatable = false, insertable = false)
    @ManyToOne(targetEntity = RelationType.class, fetch = FetchType.EAGER)
    private RelationType relationType;

    @NotNull
    @Column(name = "create_date")
    private Date createDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Long getPersonRelationId() {
        return personRelationId;
    }

    public void setPersonRelationId(Long personRelationId) {
        this.personRelationId = personRelationId;
    }

    public Person getPersonRelation() {
        return personRelation;
    }

    public void setPersonRelation(Person personRelation) {
        this.personRelation = personRelation;
    }

    public Long getRelationTypeId() {
        return relationTypeId;
    }

    public void setRelationTypeId(Long relationTypeId) {
        this.relationTypeId = relationTypeId;
    }

    public RelationType getRelationType() {
        return relationType;
    }

    public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
