package ru.bot.telegramm_bot.repository;


import org.springframework.data.repository.CrudRepository;
import ru.bot.telegramm_bot.model.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, Integer> {

    Authority findByAuthority(String authority);
}