package ru.bot.telegrammbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.bot.telegrammbot.model.Cities;
import ru.bot.telegrammbot.model.Place;
import ru.bot.telegrammbot.service.PlaceService;

@Controller
public class PlaceEditController {
    @Autowired
    PlaceService placeService;

    @PostMapping(value = {"/addPlaceFromEditPlace"})
    public String addCity(@ModelAttribute Place place, @ModelAttribute Cities cities) {
        System.out.println(" ++++++++++++++++   " + place + " " + cities);
        placeService.putPlace(place);
        return "redirect:/editPlace?id=" + cities.getId();
    }
}
