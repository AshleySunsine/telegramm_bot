package ru.bot.telegrammbot.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.bot.telegrammbot.bot.commands.ButtonCommand;
import ru.bot.telegrammbot.model.Cities;
import ru.bot.telegrammbot.model.Place;
import ru.bot.telegrammbot.service.CitiesService;
import ru.bot.telegrammbot.service.PhrasesService;

import java.util.List;
import java.util.Random;

@Component
public class BotStarter extends TelegramLongPollingCommandBot {
    @Autowired
    private CitiesService citiesService;

    @Autowired
    private PhrasesService phrasesService;

    private final String botName = "X2nExBot";
    private final String botToken = "5576451039:AAFBMalVfMOikJHD7R7JzhchBfVbA3TSxG8";

    public BotStarter() {
        register(new ButtonCommand("button", "Кнопки"));
     }

    public void updateReceived(Update update) {
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
        return botName;
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        updateReceived(update);
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
