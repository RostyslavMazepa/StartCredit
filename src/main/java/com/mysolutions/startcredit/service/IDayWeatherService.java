package com.mysolutions.startcredit.service;

import com.mysolutions.startcredit.entity.CityWeatherCheckLoad;
import com.mysolutions.startcredit.entity.DayWeather;

import java.util.Date;
import java.util.List;

public interface IDayWeatherService {

    boolean setCityWeatherType();

    List<CityWeatherCheckLoad> getCityWeatherCheckLoadByTodayDate(java.sql.Date date);

    boolean getWeatherAutoByDateAndCity();

    List<DayWeather> getWeatherByDateAndCity(String city, Date date, java.sql.Date toDate);

    List<DayWeather> getDayWeatherByCityAndForecastDate(String city, java.sql.Date date);

    List<DayWeather> gerDayWeatherCityAll(String city);

    DayWeather createDayWeather(DayWeather dayWeather);
}
