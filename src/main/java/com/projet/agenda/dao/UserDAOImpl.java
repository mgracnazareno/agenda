package com.projet.agenda.dao;

import com.projet.agenda.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{

    //define field for Entity Manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(User user){
        entityManager.persist(user);
    }



}
