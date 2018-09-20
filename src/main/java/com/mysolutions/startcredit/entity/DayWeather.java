package com.mysolutions.startcredit.entity;

import javax.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "days_weather")
public class DayWeather {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "download_date")
    private Date downloadDate;
    @Column(name = "forecast_date")
    private Date forecastDate;

    @Column(name = "city")
    private String city;

    @Column(name = "url_weather_text")
    private String urlWeatherText;
    @Column(name = "url_weather_img")
    private String urlWeatherImg;

    @Column(name = "temperature")
    private String temperature;
    @Column(name = "temperature_feeling")
    private String temperatureFeeling;

    @Column(name = "pressure")
    private String pressure;

    @Column(name = "humidity")
    private String humidity;

    @Column(name = "wind_speed")
    private String windSpeed;
    @Column(name = "wind_direction")
    private String windDirection;

    @Column(name = "probability_precipitation")
    private String probabilityPrecipitation;

    public DayWeather() {
    }

    public DayWeather(
            Date downloadDate,
            Date forecastDate,
            String city,
            String urlWeatherText,
            String urlWeatherImg,
            String temperature,
            String temperatureFeeling,
            String pressure,
            String humidity,
            String windSpeed,
            String windDirection,
            String probabilityPrecipitation
    ) {
        this.downloadDate = downloadDate;
        this.forecastDate = forecastDate;
        this.city = city;
        this.urlWeatherText = urlWeatherText;
        this.urlWeatherImg = urlWeatherImg;
        this.temperature = temperature;
        this.temperatureFeeling = temperatureFeeling;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.probabilityPrecipitation = probabilityPrecipitation;
    }

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(Date downloadDate) {
        this.downloadDate = downloadDate;
    }

    public Date getForecastDate() {
        return forecastDate;
    }

    public void setForecastDate(Date forecastDate) {
        this.forecastDate = forecastDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUrlWeatherText() {
        return urlWeatherText;
    }

    public void setUrlWeatherText(String urlWeatherText) {
        this.urlWeatherText = urlWeatherText;
    }

    public String getUrlWeatherImg() {
        return urlWeatherImg;
    }

    public void setUrlWeatherImg(String urlWeatherImg) {
        this.urlWeatherImg = urlWeatherImg;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getTemperatureFeeling() {
        return temperatureFeeling;
    }

    public void setTemperatureFeeling(String temperatureFeeling) {
        this.temperatureFeeling = temperatureFeeling;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getProbabilityPrecipitation() {
        return probabilityPrecipitation;
    }

    public void setProbabilityPrecipitation(String probabilityPrecipitation) {
        this.probabilityPrecipitation = probabilityPrecipitation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DayWeather that = (DayWeather) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(downloadDate, that.downloadDate) &&
                Objects.equals(forecastDate, that.forecastDate) &&
                Objects.equals(city, that.city) &&
                Objects.equals(urlWeatherText, that.urlWeatherText) &&
                Objects.equals(urlWeatherImg, that.urlWeatherImg) &&
                Objects.equals(temperature, that.temperature) &&
                Objects.equals(temperatureFeeling, that.temperatureFeeling) &&
                Objects.equals(pressure, that.pressure) &&
                Objects.equals(humidity, that.humidity) &&
                Objects.equals(windSpeed, that.windSpeed) &&
                Objects.equals(windDirection, that.windDirection) &&
                Objects.equals(probabilityPrecipitation, that.probabilityPrecipitation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, downloadDate, forecastDate, city, urlWeatherText, urlWeatherImg, temperature, temperatureFeeling, pressure, humidity, windSpeed, windDirection, probabilityPrecipitation);
    }

    @Override
    public String toString() {
        return "DayWeather{" +
                "id=" + id +
                ", downloadDate=" + downloadDate +
                ", forecastDate=" + forecastDate +
                ", city='" + city + '\'' +
                ", urlWeatherText='" + urlWeatherText + '\'' +
                ", urlWeatherImg='" + urlWeatherImg + '\'' +
                ", temperature='" + temperature + '\'' +
                ", temperatureFeeling='" + temperatureFeeling + '\'' +
                ", pressure='" + pressure + '\'' +
                ", humidity='" + humidity + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", windDirection='" + windDirection + '\'' +
                ", probabilityPrecipitation='" + probabilityPrecipitation + '\'' +
                '}';
    }
}
