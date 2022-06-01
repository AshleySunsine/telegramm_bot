package ru.bot.telegrammbot.repository;

import org.springframework.data.repository.CrudRepository;
import ru.bot.telegrammbot.model.Place;

public interface PlaceRepository extends CrudRepository<Place, Long> {
}
