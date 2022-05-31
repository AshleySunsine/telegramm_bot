package ru.bot.telegramm_bot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.bot.telegramm_bot.model.Phrases;

public interface PhrasesRepository extends CrudRepository<Phrases, Long> {
    @Query(value = "SELECT * FROM Phrases ORDER BY random() limit 1", nativeQuery = true)
    Phrases getRandomPhrase();
}
