package com.mysolutions.startcredit.repository;

import com.mysolutions.startcredit.entity.DayWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface IDayWeatherRepository extends JpaRepository<DayWeather, Long> {

    List<DayWeather> getDayWeatherByCity(String city);

    List<DayWeather> getDayWeatherByCityAndForecastDate(String city, Date date);

}
