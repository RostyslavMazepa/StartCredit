package com.mysolutions.startcredit.repository;

import com.mysolutions.startcredit.entity.CityWeatherCheckLoad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ICityWeatherCheckLoadRepository extends JpaRepository<CityWeatherCheckLoad, Long> {

    @Query(value = "SELECT entity FROM CityWeatherCheckLoad entity WHERE " +
            "entity.insertDate = :date " +
            "AND entity.checkDate = null")
    List<CityWeatherCheckLoad> findCityWeatherCheckLoadsByInsertDateAndCheckDateNull(@Param("date") Date date);

    @Query(value = "SELECT entity FROM CityWeatherCheckLoad entity WHERE entity.insertDate = :date AND entity.checkDate = :date")
    List<CityWeatherCheckLoad> findCityWeatherCheckLoadsByInsertDateAndCheckDate(@Param("date") Date date);
}
