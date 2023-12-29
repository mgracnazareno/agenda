package com.projet.agenda.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 128, nullable = false, unique = true)
    private String email;

    @Column(length = 64, nullable = false)
    private String password;

    @Column(length = 64, nullable = false)
    private String nom;
    @Column(length = 64, nullable = false)
    private String prenom;
    private String photo;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(unique = true, nullable = false, length=150)
    private String username;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    private boolean enabled;

    //association
    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, fetch =FetchType.LAZY)
    private Set<Event> createEvents = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "users_authorities",
            joinColumns = @JoinColumn(name="users_id"),
            inverseJoinColumns = @JoinColumn(name="authorities_id")

    )
    private Set<Authorities> authorities = new HashSet<>();


    @ManyToOne
    @JoinColumn(name="admin_id")
    private Admin admin;
    public User(){}

    public User(String nom, String prenom, String email, String password){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public User(String prenom, String nom, String email){
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
    }

    public User(int id, String email, boolean enabled, String nom, String prenom, String password, String photo) {
        this.id = id;
        this.email = email;
        this.nom = nom;
        this.enabled = enabled;
        this.prenom = prenom;
        this.password = password;
        this.photo = photo;
        authorities = new HashSet();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }




    public Set<Authorities> getRoles() {
        return authorities;
    }

    public void setRoles(Set<Authorities> authorities) {
        this.authorities = authorities;
    }

    public String afficherTitreDesColonnes() {
        String message = "";
        message = String.format(" %-10s  %30s %15s %15s %15s %15s %25s", "Id", "Email", "Active", "Nom", "Prenom",
                "Password", "Photo");
        message+="\n --------------------------------------------------------------------------------------------------------------------------------------";
        return message;
    }

    @Override
    public String toString() {
        String message = "";
        message = String.format(" %-10d  %30s %15b %15s %15s %15s %25s ",this.id,this.email, this.enabled,this.nom,this.prenom,
                this.password, this.photo);
        return message;
    }


    // Method to add an event created by the user

}
