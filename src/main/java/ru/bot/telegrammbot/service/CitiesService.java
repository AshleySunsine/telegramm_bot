package ru.bot.telegrammbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bot.telegrammbot.model.Cities;
import ru.bot.telegrammbot.model.Place;
import ru.bot.telegrammbot.repository.CityRepository;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println(city);
        return cityRepository.findByCityName(city);
    }

    public Cities getCityById(int id) {
        return cityRepository.findById(id).get();
    }

    public Cities putCity(Cities newCity, Place newPlace) {
        Cities city = getCity(newCity.getCityName());
        if (city != null) {
            city.getPlace().add(newPlace);
            cityRepository.save(city);
        } else {
            newCity.getPlace().add(newPlace);
            city = cityRepository.save(newCity);
        }
        return city;
    }

    public List<Cities> getAllCities() {
        List<Cities> result = new ArrayList<Cities>();
        cityRepository.findAll().forEach(result::add);
        return result;
    }

    public void deleteCity(int cityId) {
        cityRepository.deleteById((long) cityId);
    }

    public Cities deletePlace(int cityId, int placeId) {
        Cities city = getCityById(cityId);
        Place place = new Place();
        if (city != null) {
          for (int i = 0; i < city.getPlace().size(); i++) {
              if (city.getPlace().get(i).getId() == placeId) {
                  city.getPlace().remove(i);
                  cityRepository.save(city);
              }
          }
        }
        return city;
    }



}
