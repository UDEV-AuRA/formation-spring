package com.ipiecoles.formation.tpspring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ipiecoles.formation.tpspring.model.Type;
import com.ipiecoles.formation.tpspring.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {


    public static final RowMapper USER_ROW_MAPPER = new RowMapper() {
        @Nullable
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User u = new User();
            u.setId(resultSet.getLong("id"));
            u.setLogin(resultSet.getString("login"));
            u.setType(Type.valueOf(resultSet.getString("type")));
            return u;
        }
    };

    private JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User findById(Long idUser) {
        List<User> users = jdbcTemplate.query("SELECT * FROM user WHERE id = ?", new Object[]{idUser}, USER_ROW_MAPPER);
        return users.stream().findFirst().orElse(null);
    }

}
