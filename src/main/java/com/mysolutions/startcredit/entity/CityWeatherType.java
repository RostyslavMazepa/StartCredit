package com.mysolutions.startcredit.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "city_weather_type")
public class CityWeatherType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "city")
    String city;

    public CityWeatherType(String city) {
        this.city = city;
    }

    public CityWeatherType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityWeatherType that = (CityWeatherType) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city);
    }

    @Override
    public String toString() {
        return "CityWeatherType{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}';
    }
}
