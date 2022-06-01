package ru.bot.telegrammbot.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cities {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String cityName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Place> place = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Place> getPlace() {
        return place;
    }

    public void setPlace(List<Place> places) {
        this.place = places;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cities cities = (Cities) o;
        return id == cities.id && Objects.equals(cityName, cities.cityName) && Objects.equals(place, cities.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityName, place);
    }

    @Override
    public String toString() {
        return "Cities{"
               + "id=" + id
               + ", city_name='" + cityName + '\''
               + ", places=" + place
               + '}';
    }
}
