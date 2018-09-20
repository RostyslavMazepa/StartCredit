package com.mysolutions.startcredit.controller;

import com.mysolutions.startcredit.entity.DayWeather;
import com.mysolutions.startcredit.service.DayWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;

@Controller
public class DayWeatherController {

    @Autowired
    private DayWeatherService dayWeatherService;

    @GetMapping("/day-weather")
    public ResponseEntity<List<DayWeather>> getDayWeather(@RequestParam("city") String city, @RequestParam("date") String date) throws IOException {

        SimpleDateFormat stringDateFormat = new SimpleDateFormat();
        stringDateFormat.applyPattern("yyyy-MM-dd");

        java.util.Date utilDate = null;
        Date forecastDate = null;

        try {
            utilDate = stringDateFormat.parse(date);
            forecastDate = new Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<DayWeather> listDayWeather = dayWeatherService.getDayWeatherByCityAndForecastDate(city, forecastDate);
        return new ResponseEntity<List<DayWeather>>(listDayWeather, HttpStatus.OK);
    }
}
