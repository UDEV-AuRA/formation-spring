package com.ipiecoles.formation.tpspring.repository;

import com.ipiecoles.formation.tpspring.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepository {


    @PersistenceContext
    private EntityManager entityManager;

    public User findById(Long idUser) {
       return entityManager.find(User.class, idUser);
    }

}
