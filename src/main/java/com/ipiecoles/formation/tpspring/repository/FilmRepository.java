package com.ipiecoles.formation.tpspring.repository;

import com.ipiecoles.formation.tpspring.model.Film;
import com.ipiecoles.formation.tpspring.model.Type;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class FilmRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Film> findParType(Type type) {
        TypedQuery<Film> query = entityManager.createQuery("SELECT f FROM Film f WHERE f.type=:type", Film.class);
        query.setParameter("type", type);
        return query.getResultList();
    }

    public Film findByTitle(String title) {
        TypedQuery<Film> query = entityManager.createQuery("SELECT f FROM Film f WHERE f.titre=:titre", Film.class);
        query.setParameter("titre", title);
        return query.getResultList().stream().findFirst().orElse(null);
    }
}
