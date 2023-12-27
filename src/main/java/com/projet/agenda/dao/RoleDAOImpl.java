package com.projet.agenda.dao;

import com.projet.agenda.model.Role;
import com.projet.agenda.model.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO{
    //define field for Entity Manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public RoleDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Role role){
        entityManager.persist(role);
    }
}
