package ru.bot.telegramm_bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bot.telegramm_bot.model.Cities;
import ru.bot.telegramm_bot.repository.CityRepository;

@Component
public class CitiesService {
    @Autowired
    CityRepository cityRepository;

    public CitiesService() {
    }

    public CitiesService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Cities getCity(String city) {
        city = city.toLowerCase().split(" ", 1)[0];
        return cityRepository.findByCityName(city);
    }

}
