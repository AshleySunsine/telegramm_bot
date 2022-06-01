package ru.bot.telegrammbot.repository;


import org.springframework.data.repository.CrudRepository;
import ru.bot.telegrammbot.model.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, Integer> {

    Authority findByAuthority(String authority);
}