package ru.bot.telegramm_bot.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cities {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String city_name;

    @OneToMany
    private List<Place> place = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public List<Place> getPlace() {
        return place;
    }

    public void setPlace(List<Place> places) {
        this.place = places;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cities cities = (Cities) o;
        return id == cities.id && Objects.equals(city_name, cities.city_name) && Objects.equals(place, cities.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city_name, place);
    }

    @Override
    public String toString() {
        return "Cities{" +
                "id=" + id +
                ", city_name='" + city_name + '\'' +
                ", places=" + place +
                '}';
    }
}
