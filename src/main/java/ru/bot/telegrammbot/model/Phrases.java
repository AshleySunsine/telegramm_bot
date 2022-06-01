package ru.bot.telegrammbot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Phrases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String phrase;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Phrases phrases = (Phrases) o;
        return id == phrases.id && Objects.equals(phrase, phrases.phrase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phrase);
    }

    @Override
    public String toString() {
        return "Phrases{"
               + "id=" + id
               + ", phrase='" + phrase + '\''
               + '}';
    }
}
