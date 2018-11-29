package com.mysolutions.startcredit.service;

import com.mysolutions.startcredit.entity.CityWeatherCheckLoad;
import com.mysolutions.startcredit.entity.CityWeatherType;
import com.mysolutions.startcredit.entity.DayWeather;
import com.mysolutions.startcredit.repository.ICityWeatherCheckLoadRepository;
import com.mysolutions.startcredit.repository.ICityWeatherTypeRepository;
import com.mysolutions.startcredit.repository.IDayWeatherRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@EnableScheduling
public class DayWeatherService implements IDayWeatherService {

    @Autowired
    private IDayWeatherRepository dayWeatherRepository;

    @Autowired
    private ICityWeatherTypeRepository cityWeatherTypeRepository;

    @Autowired
    private ICityWeatherCheckLoadRepository cityWeatherCheckLoadRepository;

    @Override
    public boolean setCityWeatherType() {

        int sizeCityWeatherType = cityWeatherTypeRepository.findAll().size();

        String[] cityArray = {"Київ", "Гореничі", "Коростышев", "Страхолісся"};

        if (sizeCityWeatherType < cityArray.length) {
            for (int c = 0; c < cityArray.length; c++) {
                if (!cityWeatherTypeRepository.existsCityWeatherTypeByCity(cityArray[c])) {
                    CityWeatherType cityWeatherType = new CityWeatherType(cityArray[c]);
                    cityWeatherTypeRepository.save(cityWeatherType);
                }
            }
            return true;
        }
        return true;
    }

    @Override
    public List<CityWeatherCheckLoad> getCityWeatherCheckLoadByTodayDate(Date date) {

        /** Кількість міст по яким сьогодні загружались дані погоди */
        int sizeWeatherCheckLoadsByInsertDateAndCheckDate = cityWeatherCheckLoadRepository.findCityWeatherCheckLoadsByInsertDateAndCheckDate(date).size();
        /** Кількість міст по яким сьогодні потрібно загрузити дані погоди */
        int sizeWeatherCheckLoadsByInsertDateAndCheckDateNull = cityWeatherCheckLoadRepository.findCityWeatherCheckLoadsByInsertDateAndCheckDateNull(date).size();

        if (sizeWeatherCheckLoadsByInsertDateAndCheckDate == 0 &&
                sizeWeatherCheckLoadsByInsertDateAndCheckDateNull == 0) {

            List<CityWeatherType> cityWeatherTypeList = cityWeatherTypeRepository.findAll();
            for (int cw = 0; cw < cityWeatherTypeList.size(); cw++) {
                CityWeatherCheckLoad cityWeatherCheckLoad = new CityWeatherCheckLoad();
                cityWeatherCheckLoad.setCityId(cityWeatherTypeList.get(cw).getId());
                cityWeatherCheckLoad.setInsertDate(date);

                cityWeatherCheckLoadRepository.save(cityWeatherCheckLoad);
            }
        } else if (sizeWeatherCheckLoadsByInsertDateAndCheckDate > 0 &&
                sizeWeatherCheckLoadsByInsertDateAndCheckDateNull == 0) {
            return cityWeatherCheckLoadRepository.findCityWeatherCheckLoadsByInsertDateAndCheckDateNull(date);
        }
        return cityWeatherCheckLoadRepository.findCityWeatherCheckLoadsByInsertDateAndCheckDateNull(date);
    }

    @Override
    @Scheduled(fixedRate = 5000 * 2/*1000 * 60 * 60 * 24*/)
    public boolean getWeatherAutoByDateAndCity() {

        java.util.Date date = new java.util.Date();

        Date todayDate = new Date(date.getTime());

        setCityWeatherType();

        List<CityWeatherCheckLoad> cityWeatherCheckLoadList = getCityWeatherCheckLoadByTodayDate(todayDate);

        if ( cityWeatherCheckLoadList.size() > 0 ) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 10; j++) {
                    CityWeatherCheckLoad cityWeatherCheckLoad = cityWeatherCheckLoadList.get(i);

                    String city = cityWeatherCheckLoad.getCityWeatherType().getCity();

                    Date dateNext = new Date(todayDate.getTime() + (1000 * 60 * 60 * 24) * j);
                    getWeatherByDateAndCity(city, dateNext, todayDate);

                    cityWeatherCheckLoad.setCheckDate(todayDate);
                    cityWeatherCheckLoadRepository.save(cityWeatherCheckLoad);
                }
            }
            return true;
        } else if ( cityWeatherCheckLoadList.size() == 0 ) {
            return false;
        }
        return true;
    }

    @Override
    public List<DayWeather> getWeatherByDateAndCity(String city, java.util.Date date, Date toDate) {

        List<DayWeather> dayWeatherList = new ArrayList();

        java.util.Date[] forecastDateArray;
        String[] urlWeatherTextArray;
        String[] urlWeatherImgArray;
        String[] temperatureArray;
        String[] temperatureFeelingArray;
        String[] pressureArray;
        String[] humidityArray;
        String[] windSpeedArray;
        String[] windDirectionArray;
        String[] probabilityPrecipitationArray;

        String dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);

        try {
            Document document = Jsoup.connect("https://sinoptik.ua/погода-" + city + "/" + dateString).get();

            Elements classWeatherDetails = document.getElementsByAttributeValue("class", "weatherDetails");

            Elements trs = classWeatherDetails.select("tr");
            trs.remove(0);
            int trSize = trs.size();

            Element element = trs.get(0);
            Elements elements = element.getElementsByTag("td");
            int tdSize = elements.size();

            forecastDateArray = new java.util.Date[tdSize];
            urlWeatherTextArray = new String[tdSize];
            urlWeatherImgArray = new String[tdSize];
            temperatureArray = new String[tdSize];
            temperatureFeelingArray = new String[tdSize];
            pressureArray = new String[tdSize];
            humidityArray = new String[tdSize];
            windSpeedArray = new String[tdSize];
            windDirectionArray = new String[tdSize];
            probabilityPrecipitationArray = new String[tdSize];

            for (int i = 0; i < trSize; i++) {

                Element elem = trs.get(i);
                Elements elems = elem.getElementsByTag("td");

                for (int j = 0; j < tdSize; j++) {
                    if (i == 0) {
                        String times = elems.get(j).text().replaceAll(" ", "");
/** */
                        String stringDate = dateString + " " + times;
                        SimpleDateFormat stringDateFormat = new SimpleDateFormat();
                        stringDateFormat.applyPattern("yyyy-MM-dd HH:mm");

                        java.util.Date forecastDate = stringDateFormat.parse(stringDate);
                        forecastDateArray[j] = forecastDate;
                    } else if (i == 1) {
                        String urlWeatherText = elems.get(j).getElementsByTag("div").attr("title");
                        String urlWeatherImg = elems.get(j).getElementsByTag("img").attr("src");

                        urlWeatherTextArray[j] = urlWeatherText;
                        urlWeatherImgArray[j] = urlWeatherImg;
                    } else if (i == 2) {
                        String temperature = elems.get(j).text();

                        temperatureArray[j] = temperature;
                    } else if (i == 3) {
                        String temperatureFeeling = elems.get(j).text();

                        temperatureFeelingArray[j] = temperatureFeeling;
                    } else if (i == 4) {
                        String pressure = elems.get(j).text();

                        pressureArray[j] = pressure;
                    } else if (i == 5) {
                        String humidity = elems.get(j).text();

                        humidityArray[j] = humidity;
                    } else if (i == 6) {
                        String windSpeed = elems.get(j).getElementsByTag("div").text();
                        String windDirection = elems.get(j).getElementsByTag("div").attr("data-tooltip");

                        windSpeedArray[j] = windSpeed;
                        windDirectionArray[j] = windDirection;
                    } else if (i == 7) {
                        String probabilityPrecipitation = elems.get(j).text().replaceAll("-", "");

                        probabilityPrecipitationArray[j] = probabilityPrecipitation;
                    }
                }
            }

            for (int l = 0; l < forecastDateArray.length; l++) {
                dayWeatherList.add(
                        createDayWeather(
                                new DayWeather(
                                        toDate,
                                        forecastDateArray[l],
                                        city,
                                        urlWeatherTextArray[l] ,
                                        urlWeatherImgArray[l] ,
                                        temperatureArray[l] ,
                                        temperatureFeelingArray[l] ,
                                        pressureArray[l] ,
                                        humidityArray[l] ,
                                        windSpeedArray[l] ,
                                        windDirectionArray[l] ,
                                        probabilityPrecipitationArray[l]
                                )
                        )
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Сайт sinoptik.ua не доступний !!!");
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dayWeatherList;
    }

    @Override
    public List<DayWeather> getDayWeatherByCityAndForecastDate(String city, Date date) {
        return dayWeatherRepository.getDayWeatherByCityAndForecastDate(city, date);
    }

    @Override
    public List<DayWeather> gerDayWeatherCityAll(String city){
        return dayWeatherRepository.getDayWeatherByCity(city);
    }

    @Override
    public DayWeather createDayWeather(DayWeather dayWeather){
        if (dayWeatherRepository.equals(dayWeather)) {
            return dayWeatherRepository.getOne(dayWeather.getId());
        } else {
            return dayWeatherRepository.save(dayWeather);
        }

    }
}
