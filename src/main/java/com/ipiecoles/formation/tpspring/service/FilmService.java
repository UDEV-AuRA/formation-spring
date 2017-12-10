package com.ipiecoles.formation.tpspring.service;

import com.ipiecoles.formation.tpspring.model.Film;
import com.ipiecoles.formation.tpspring.model.Type;
import com.ipiecoles.formation.tpspring.repository.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    private FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> findNouveautesParType(Type type) {
        return filmRepository.findParType(type);
    }


    public Film findByTitle(String title) {
        return filmRepository.findByTitle(title);
    }
}
