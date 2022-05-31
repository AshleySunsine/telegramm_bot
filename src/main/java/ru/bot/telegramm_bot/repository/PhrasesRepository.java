package ru.bot.telegramm_bot.repository;

import org.springframework.data.repository.CrudRepository;
import ru.bot.telegramm_bot.model.Phrases;

public interface PhrasesRepository extends CrudRepository<Phrases, Long> {
}
