package com.ipiecoles.formation.tpspring.repository;

import java.util.ArrayList;
import java.util.List;

import com.ipiecoles.formation.tpspring.model.Type;
import com.ipiecoles.formation.tpspring.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    {
        User john = new User();
        john.setId(1L);
        john.setLogin("john");
        john.setType(Type.SF);
        users.add(john);
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
