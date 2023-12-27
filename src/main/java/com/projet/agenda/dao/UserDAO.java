package com.projet.agenda.dao;

import com.projet.agenda.model.User;
import org.springframework.stereotype.Repository;


public interface UserDAO {
    void save(User user);
}
