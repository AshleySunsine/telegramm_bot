package ru.bot.telegrammbot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.bot.telegrammbot.model.Cities;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends CrudRepository<Cities, Long> {
    @Query("from Cities ct join fetch ct.place where LOWER(ct.cityName)=:city_name")
    Cities findByCityName(String city_name);

    Optional<Cities> findById(long id);

    List<Cities> findAll();


}
