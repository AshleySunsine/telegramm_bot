package ru.bot.telegramm_bot.repository;

import org.springframework.data.repository.CrudRepository;
import ru.bot.telegramm_bot.model.Place;

public interface PlaceRepository extends CrudRepository<Place, Long> {
}
