package com.projet.agenda.service;

import com.projet.agenda.model.Authorities;
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

    public List<Authorities>afficherRoles(){
        return (List<Authorities>) roleRepos.findAll();
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

    public List<User> findByPrenomAndNom(String prenom){
        return repo.findByNom(prenom);
    }
    public List<User> findByNom(String nom){
        return repo.findByNom(nom);
    }

    public List<User> searchUsers(String prenom, String nom) {
        return repo.findByPrenomContainingIgnoreCaseAndNomContainingIgnoreCase(prenom, nom);
    }

    public User getUserByUsername(String username) {
        return repo.getUserByEmail(username);
    }

}
