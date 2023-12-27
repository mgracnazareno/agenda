package com.projet.agenda.service;

import com.projet.agenda.model.Role;
import com.projet.agenda.model.User;
import com.projet.agenda.repos.RoleRepository;
import com.projet.agenda.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    @Autowired
    private RoleRepository roleRepos;

    public List<User> afficherUsers(){
        return (List<User>) repo.findAllByOrderByNomAsc();
    }

    public List<Role>afficherRoles(){
        return (List<Role>) roleRepos.findAll();
    }

    public User ajouterUser(User user ){
        return repo.save(user);
    }

    public User get(Integer id) throws UserNotFoundException {
        try {
            return  repo.findById(id).get();
        }catch(NoSuchElementException exception){
            throw new UserNotFoundException("On ne peut pas trouver un utilisateur avec l'id " + id);
        }
    }
    public Optional<User> findUserById(Integer id){
        return repo.findByUserId(id);
    }

    public void deleteUserById(Integer id) throws UserNotFoundException {
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            // Handle exceptions when the user with the given ID is not found or unable to delete
            throw new UserNotFoundException("On ne peut pas supprimer un user avec l'id: " + id);
        }
    }
//    public List<User> findById(Integer id){
//        Optional<User> result = repo.findById(id);
//        User user = null;
//        if(result.isPresent()){
//            user = result.get();
//        }else{
//            // user with id is not found
//            throw new RuntimeException("On ne peut pas trouver un utilisateur avec l'id " + id);
//        }
//        return user;
//    }


}
