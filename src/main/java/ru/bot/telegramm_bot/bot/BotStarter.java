package ru.bot.telegramm_bot.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.bot.telegramm_bot.model.Cities;
import ru.bot.telegramm_bot.model.Phrases;
import ru.bot.telegramm_bot.model.Place;
import ru.bot.telegramm_bot.service.CitiesService;
import ru.bot.telegramm_bot.service.PhrasesService;

import java.util.List;
import java.util.Random;

@Component
public class BotStarter extends TelegramLongPollingBot {
    @Autowired
    private CitiesService citiesService;

    @Autowired
    private PhrasesService phrasesService;

    private String BOT_NAME = "X2nExBot";
    private String BOT_TOKEN = "5576451039:AAFBMalVfMOikJHD7R7JzhchBfVbA3TSxG8";

    @Override
    public void onUpdateReceived(Update update) {
        String cityString = update.getMessage().getText();

        StringBuilder stringBuilder = new StringBuilder();
        try {
            SendMessage sm = new SendMessage();
            sm.setChatId(update.getMessage().getChatId().toString());
            stringBuilder
                    .append(" ")
                    .append(phrasesService.getInvitationPhrases())
                    .append(" ");
            Cities city = citiesService.getCity(cityString);
            List<Place> places = city.getPlace();
            Place place = places.get(new Random().nextInt(places.size()));
            stringBuilder.append(place.getPlaceName())
                    .append(System.lineSeparator())
                    .append(" ")
                    .append(place.getPlaceDiscript());
            sm.setText(stringBuilder.toString());
            execute(sm);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}
