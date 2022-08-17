package ru.bot.telegrammbot.bot.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class ButtonCommand extends Commands {

    private final String identifier;
    private final String description;
    public ButtonCommand(String identifier, String description) {
        super(identifier, description);
        this.description = description;
        this.identifier = identifier;
    }

    public void execute(AbsSender absSender, Update update, String[] strings) {
        sendAnswer(absSender, update.getMessage().getChatId(), identifier,
                "Давайте начнём! Если Вам нужна помощь, нажмите /help");
    }
}
