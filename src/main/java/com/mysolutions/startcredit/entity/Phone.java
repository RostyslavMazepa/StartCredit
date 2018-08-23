package com.mysolutions.startcredit.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "phone")
public class Phone {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "phone_type_id")
    private Long documentTypeId;

    @JoinColumn(name = "phone_type_id", updatable = false, insertable = false)
    @ManyToOne(targetEntity = PhoneType.class, fetch = FetchType.EAGER)
    private PhoneType phoneType;

    @NotNull
    @Column(name = "person_id")
    private Long personId;

    @JoinColumn(name = "person_id", updatable = false, insertable = false)
    @ManyToOne(targetEntity = Person.class, fetch = FetchType.EAGER)
    private Person person;

    @NotNull
    @Column(name = "number_phone")
    private String numberPhone;

    @Column(name = "priority")
    @NotNull
    private Boolean priority; // 0 - використовується не часто, 1 - використовується часто

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Long documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public long getPersonId() {
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

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public Boolean getPriority() {
        return priority;
    }

    public void setPriority(Boolean priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return id == phone.id &&
                documentTypeId == phone.documentTypeId &&
                personId == phone.personId &&
                Objects.equals(phoneType, phone.phoneType) &&
                Objects.equals(person, phone.person) &&
                Objects.equals(numberPhone, phone.numberPhone) &&
                Objects.equals(priority, phone.priority);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, documentTypeId, phoneType, personId, person, numberPhone, priority);
    }
}
