package com.mysolutions.startcredit.repository;

import com.mysolutions.startcredit.entity.CityWeatherType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityWeatherTypeRepository extends JpaRepository<CityWeatherType, Long> {
    boolean existsCityWeatherTypeByCity (String city);
}
