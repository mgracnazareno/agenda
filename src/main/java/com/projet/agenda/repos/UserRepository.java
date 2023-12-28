package com.projet.agenda.repos;

import com.projet.agenda.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.email= :email")
    public User getUserByEmail(@Param("email")String email);

    @Query("SELECT u FROM User u WHERE u.email = :email and u.password = :password")
    public User getUserByEmailAndPassword(@Param("email")String email, @Param("password")String password);

    public Long countById(Integer id);
    @Query("UPDATE User  u SET u.active= ?2 WHERE u.id = ?1")
    @Modifying
    public void updateActiveStatus(Integer id, boolean active);

    @Query("SELECT u FROM User u where u.nom LIKE %?1% OR u.prenom LIKE %?1%")
    public List<User> findAll(String keyword);

    @Query("SELECT u FROM User u join u.roles r WHERE r.nom = ?1")
    public List<User> findAllByRolesNom(String nom);

    //a method that sorts by last name
    @Query("SELECT u FROM User u ORDER BY u.nom ASC")
    public List<User>findAllByOrderByNomAsc();

    //a method that find User by Id
    @Query("SELECT u FROM User u WHERE u.id = :id")
    public Optional<User> findByUserId(@Param("id") Integer id);

    @Query("SELECT u From User u WHERe u.prenom LIKE %:prenom%")
    List<User> findByPrenom(@Param("prenom") String prenom);

    @Query("SELECT u From User u WHERe u.nom LIKE %:nom%")
    List<User> findByNom(@Param("nom") String nom);

    List<User> findByPrenomContainingIgnoreCaseAndNomContainingIgnoreCase(String prenom, String nom);

     @Query("SELECT u FROM User u JOIN u.roles r WHERE r.nom =?1")
    public List<User> findAllByNomAndRoles(String nom);

}
