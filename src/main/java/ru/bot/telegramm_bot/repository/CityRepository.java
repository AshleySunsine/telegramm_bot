package ru.bot.telegramm_bot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.bot.telegramm_bot.model.Cities;

public interface CityRepository extends CrudRepository<Cities, Long> {
    @Query("from Cities ct join fetch ct.place where LOWER(ct.cityName)=:city_name")
    Cities findByCityName(String city_name);
}
