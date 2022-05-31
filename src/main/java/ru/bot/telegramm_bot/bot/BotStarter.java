package ru.bot.telegramm_bot.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.bot.telegramm_bot.model.Cities;
import ru.bot.telegramm_bot.repository.CityRepository;

@Component
public class BotStarter extends TelegramLongPollingBot {
    @Autowired
    private CityRepository cityRepository;

    private String BOT_NAME = "X2nExBot";
    private String BOT_TOKEN = "5576451039:AAFBMalVfMOikJHD7R7JzhchBfVbA3TSxG8";

    @Override
    public void onUpdateReceived(Update update) {
        Cities city = new Cities();
        try {
            SendMessage sm = new SendMessage();
            sm.setChatId(update.getMessage().getChatId().toString());

             city =  cityRepository.findByCityName("Минск");
            System.out.println(city.toString());
            sm.setText(city.toString());
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
