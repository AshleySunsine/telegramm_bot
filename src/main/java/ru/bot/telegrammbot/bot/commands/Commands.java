package ru.bot.telegrammbot.bot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.bots.AbsSender;

abstract class Commands extends BotCommand {
    Commands(String identifier, String description) {
        super(identifier, description);
    }

    void sendAnswer(AbsSender absSender, Long chatId, String commandName, String text) {
        SendMessage message = new SendMessage();
        //включаем поддержку режима разметки, чтобы управлять отображением текста и добавлять эмодзи
        message.enableMarkdown(true);
        message.setChatId(chatId.toString());
        message.setText(text);
        try {
            absSender.execute(message);
        } catch (Exception e) {
            //логируем
        }
    }
}