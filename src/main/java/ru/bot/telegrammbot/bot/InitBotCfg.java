package ru.bot.telegrammbot.bot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.bot.telegrammbot.service.CitiesService;
import ru.bot.telegrammbot.service.PhrasesService;

@Configuration
public class InitBotCfg {

    @Bean
    public PhrasesService getPhrasesService() {
        return new PhrasesService();
    }

    @Bean
    public CitiesService getCitiesService() {
        return new CitiesService();
    }
    @Bean
    public BotStarter getBotStarter() {
        return new BotStarter();
    }

    @Bean
    public TelegramBotsApi getTelegramsBotApi(BotStarter botStarter) {
        TelegramBotsApi telegramBotsApi = null;
        try {
        telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(getBotStarter());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return telegramBotsApi;
    }
}
