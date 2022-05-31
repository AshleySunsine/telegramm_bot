package ru.bot.telegramm_bot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.bot.telegramm_bot.model.Cities;
import ru.bot.telegramm_bot.model.Place;

@Controller
public class IndexController {

    @GetMapping(value = { "/" })
    public String index(Model model) {
        String message = "Hello Spring Boot + JSP";
        model.addAttribute("message", message);
        return "index";
    }

    @PostMapping(value = {"/addCity"})
    public String addCity(@ModelAttribute Cities city, @ModelAttribute Place place) {
        System.out.println(city.toString());
        System.out.println(place.toString());
        return "index";
    }
}
