package com.mysolutions.startcredit.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "relation_type")
public class RelationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    @NotNull
    private String name; // Чоловік, Дружина, Син, Дочка, Брат, Сестра

    @Column(name = "enable")
    @NotNull
    private Boolean enable; // 0 - не передавати значення, 1 - передавати значення

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
    public String toString() {
        return "RelationType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enable=" + enable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelationType that = (RelationType) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(enable, that.enable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, enable);
    }
}
