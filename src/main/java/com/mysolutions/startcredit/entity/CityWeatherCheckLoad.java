package com.mysolutions.startcredit.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "city_weather_check_load")
public class CityWeatherCheckLoad {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "city_id")
    private Long cityId;

    @JoinColumn(name = "city_id", updatable = false, insertable = false)
    @ManyToOne(targetEntity = CityWeatherType.class, fetch = FetchType.EAGER)
    private CityWeatherType cityWeatherType;

    @Column(name = "insert_date")
    private Date insertDate;

    @Column(name = "check_date")
    private Date checkDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public CityWeatherType getCityWeatherType() {
        return cityWeatherType;
    }

    public void setCityWeatherType(CityWeatherType cityWeatherType) {
        this.cityWeatherType = cityWeatherType;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityWeatherCheckLoad that = (CityWeatherCheckLoad) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(cityId, that.cityId) &&
                Objects.equals(cityWeatherType, that.cityWeatherType) &&
                Objects.equals(insertDate, that.insertDate) &&
                Objects.equals(checkDate, that.checkDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityId, cityWeatherType, insertDate, checkDate);
    }

    @Override
    public String toString() {
        return "CityWeatherCheckLoad{" +
                "id=" + id +
                ", cityId=" + cityId +
                ", cityWeatherType=" + cityWeatherType +
                ", insertDate=" + insertDate +
                ", checkDate=" + checkDate +
                '}';
    }
}
