package ru.bot.telegrammbot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bot.telegrammbot.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
