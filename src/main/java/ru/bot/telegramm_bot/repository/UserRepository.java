package ru.bot.telegramm_bot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bot.telegramm_bot.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
