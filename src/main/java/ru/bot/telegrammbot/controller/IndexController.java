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
import ru.bot.telegrammbot.service.CitiesService;

@Controller
public class IndexController {
    @Autowired
    CitiesService citiesService;

    @GetMapping(value = { "/" })
    public String index(Model model) {
        model.addAttribute("citiesList", citiesService.getAllCities());
        return "index";
    }

    @PostMapping(value = {"/addCity"})
    public String addCity(@ModelAttribute Cities city, @ModelAttribute Place place) {
        citiesService.putCity(city, place);
        return "redirect:/";
    }

    @GetMapping(value = { "/editCity" })
    public String editCity(@RequestParam("id") int id, Model model) {
        model.addAttribute("city", citiesService.getCityById(id));
        return "cityEdit";
    }

    @PostMapping(value = {"/deleteCity"})
    public String deleteCity(@RequestParam("cityId") int cityId) {
        citiesService.deleteCity(cityId);
        return "redirect:/";
    }

}
