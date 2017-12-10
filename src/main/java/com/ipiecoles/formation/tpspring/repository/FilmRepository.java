package com.ipiecoles.formation.tpspring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ipiecoles.formation.tpspring.model.Film;
import com.ipiecoles.formation.tpspring.model.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public class FilmRepository {

    public static final RowMapper FILM_ROW_MAPPER = new RowMapper() {
        @Nullable
        @Override
        public Film mapRow(ResultSet resultSet, int i) throws SQLException {
            Film f = new Film();
            f.setId(resultSet.getLong("id"));
            f.setTitre(resultSet.getString("titre"));
            f.setType(Type.valueOf(resultSet.getString("type")));
            return f;
        }
    };

    private JdbcTemplate jdbcTemplate;

    public FilmRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Film> findParType(Type type) {
        List<Film> films = jdbcTemplate.query("SELECT * FROM film WHERE type = ?", new Object[]{type.name()}, FILM_ROW_MAPPER);
        return films;
    }

    public Film findByTitle(String title) {
        List<Film> films = jdbcTemplate.query("SELECT * FROM film WHERE titre = ?", new Object[]{title}, FILM_ROW_MAPPER);
        return films.stream().findFirst().orElse(null);
    }
}
