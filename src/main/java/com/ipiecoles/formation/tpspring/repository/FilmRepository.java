package com.ipiecoles.formation.tpspring.repository;

import java.util.ArrayList;
import java.util.List;

import com.ipiecoles.formation.tpspring.model.Film;
import com.ipiecoles.formation.tpspring.model.Type;
import org.springframework.stereotype.Repository;

import static java.util.stream.Collectors.toList;

@Repository
public class FilmRepository {

    private List<Film> films = new ArrayList<>();

    public FilmRepository(List<Film> films) {
        this.films = films;
    }

    public List<Film> findParType(Type type) {
        return films.stream().filter(f -> f.getType() == type).collect(toList());
    }

    public Film findByTitle(String title) {
        return films.stream().filter(f -> f.getTitre().equals(title)).findFirst().orElse(null);
    }
}
