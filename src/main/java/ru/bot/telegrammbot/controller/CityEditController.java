package ru.bot.telegrammbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.bot.telegrammbot.model.Cities;
import ru.bot.telegrammbot.model.Place;
import ru.bot.telegrammbot.repository.PlaceRepository;
import ru.bot.telegrammbot.service.CitiesService;
import ru.bot.telegrammbot.service.PlaceService;


@Controller
public class CityEditController {

    @Autowired
    CitiesService citiesService;

    @Autowired
    PlaceService placeService;

    @PostMapping(value = {"/deletePlace"})
    public String deletePlace(@RequestParam("cityId") int cityId,
                              @RequestParam("placeId") int placeId,
                              Model model) {
        model.addAttribute("city", citiesService.deletePlace(cityId, placeId));
        return "redirect:/editCity?id=" + cityId;
    }

    @PostMapping(value = {"/addCityFromEditCity"})
    public String addCity(@ModelAttribute Cities city, @ModelAttribute Place place) {
        Cities c = citiesService.putCity(city, place);
        return "redirect:/editCity?id=" + c.getId();
    }

    @GetMapping(value = { "/editPlace" })
    public String editCity(@RequestParam("id") int id, @RequestParam("cityId") int cityId, Model model) {
        model.addAttribute("place", placeService.getPlaceById(id));
        model.addAttribute("city", citiesService.getCityById(cityId));
        return "placeEdit";
    }
}
