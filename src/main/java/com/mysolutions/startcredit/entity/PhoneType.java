package com.mysolutions.startcredit.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "phone_type")
public class PhoneType {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    @NotNull
    private String name; // Домашній, Робочий, Мобільний

    @Column(name = "enable")
    @NotNull
    private Boolean enable; // 0 - не передавати значення, 1 - передавати значення

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneType phoneType = (PhoneType) o;
        return id == phoneType.id &&
                Objects.equals(name, phoneType.name) &&
                Objects.equals(enable, phoneType.enable);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, enable);
    }
}
