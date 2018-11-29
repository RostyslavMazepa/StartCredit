package com.mysolutions.startcredit.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "place_map")
public class PlaceMap {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "latitude")
    private Double latitude;

    @NotNull
    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "altitude")
    private Double altitude;

    @NotNull
    @Column(name = "place_name")
    private String placeName;

    @NotNull
    @Column(name = "place_comments")
    private String placeComments;

    @NotNull
    @Column(name = "create_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @NotNull
    @Column(name = "person_id")
    private Long personId;

    @JoinColumn(name = "person_id", updatable = false, insertable = false)
    @ManyToOne(targetEntity = Person.class, fetch = FetchType.EAGER)
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceComments() {
        return placeComments;
    }

    public void setPlaceComments(String placeComments) {
        this.placeComments = placeComments;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceMap placeMap = (PlaceMap) o;
        return Objects.equals(id, placeMap.id) &&
                Objects.equals(latitude, placeMap.latitude) &&
                Objects.equals(longitude, placeMap.longitude) &&
                Objects.equals(altitude, placeMap.altitude) &&
                Objects.equals(placeName, placeMap.placeName) &&
                Objects.equals(placeComments, placeMap.placeComments) &&
                Objects.equals(createDate, placeMap.createDate) &&
                Objects.equals(personId, placeMap.personId) &&
                Objects.equals(person, placeMap.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, latitude, longitude, altitude, placeName, placeComments, createDate, personId, person);
    }

    @Override
    public String toString() {
        return "PlaceMap{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", placeName='" + placeName + '\'' +
                ", placeComments='" + placeComments + '\'' +
                ", createDate=" + createDate +
                ", personId=" + personId +
                ", person=" + person +
                '}';
    }
}
