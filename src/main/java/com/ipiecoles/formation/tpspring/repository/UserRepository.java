package com.ipiecoles.formation.tpspring.repository;

import java.util.ArrayList;
import java.util.List;

import com.ipiecoles.formation.tpspring.model.Type;
import com.ipiecoles.formation.tpspring.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepository(User defaultUser) {
        this.users.add(defaultUser);
    }

    public User findById(Long idUser) {
        for (User user : users) {
            if (user.getId().equals(idUser)) {
                return user;
            }
        }
        return null;
    }

}
