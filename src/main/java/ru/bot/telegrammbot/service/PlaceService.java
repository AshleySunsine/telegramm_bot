package ru.bot.telegrammbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.bot.telegrammbot.model.Cities;
import ru.bot.telegrammbot.model.Place;
import ru.bot.telegrammbot.repository.PlaceRepository;

@Component
@Service
public class PlaceService {
    @Autowired
    PlaceRepository placeRepository;

    public Place getPlaceById(long id) {
       return placeRepository.findById(id).get();
    }

    public Place putPlace(Place place) {
        System.out.println(place + "99999999999999999999");
        return placeRepository.save(place);
    }
}
