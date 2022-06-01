package ru.bot.telegrammbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bot.telegrammbot.repository.PhrasesRepository;

@Component
public class PhrasesService {
    @Autowired
    PhrasesRepository phrasesRepository;

    public String getInvitationPhrases() {
       return phrasesRepository.getRandomPhrase().getPhrase();
    }
}
