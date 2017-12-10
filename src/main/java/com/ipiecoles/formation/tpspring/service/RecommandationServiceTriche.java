package com.ipiecoles.formation.tpspring.service;

import com.ipiecoles.formation.tpspring.model.Film;
import com.ipiecoles.formation.tpspring.model.User;
import com.ipiecoles.formation.tpspring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RecommandationServiceTriche")
public class RecommandationServiceTriche implements RecommandationService {

    private FilmService filmService;

    public RecommandationServiceTriche(FilmService filmService) {
        this.filmService = filmService;
    }

    public Film getRecommandation(Long idUser) {
        return filmService.findByTitle("Epouse-moi mon pote");
    }

}
