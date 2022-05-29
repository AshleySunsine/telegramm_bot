package ru.bot.telegramm_bot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String placeName;

    private String placeDiscript;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceDiscript() {
        return placeDiscript;
    }

    public void setPlaceDiscript(String placeDiscript) {
        this.placeDiscript = placeDiscript;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return id == place.id && Objects.equals(placeName, place.placeName) && Objects.equals(placeDiscript, place.placeDiscript);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, placeName, placeDiscript);
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", placeName='" + placeName + '\'' +
                ", placeDiscript='" + placeDiscript + '\'' +
                '}';
    }
}
