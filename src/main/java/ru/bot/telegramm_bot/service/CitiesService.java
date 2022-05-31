package ru.bot.telegramm_bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bot.telegramm_bot.model.Cities;
import ru.bot.telegramm_bot.repository.CityRepository;

@Component
public class CitiesService {
    CityRepository cityRepository;

    public CitiesService() {
    }

    public CitiesService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public String getCity(String city) {
        String answer = "";
        Cities cities = cityRepository.findByCityName("Минск");
        System.out.println(cities);

        return answer;
    }

}
