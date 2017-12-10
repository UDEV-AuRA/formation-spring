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

    {
        Film justiceLeague = new Film();
        justiceLeague.setTitre("Justice League");
        justiceLeague.setType(Type.SF);
        films.add(justiceLeague);

        Film epouseMoi = new Film();
        epouseMoi.setTitre("Epouse-moi mon pote");
        epouseMoi.setType(Type.HUMOUR);
        films.add(epouseMoi);
    }

    public List<Film> findParType(Type type) {
        return films.stream().filter(f -> f.getType() == type).collect(toList());
    }
}
