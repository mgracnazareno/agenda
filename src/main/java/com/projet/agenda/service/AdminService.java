package com.projet.agenda.service;

import com.projet.agenda.model.Event;
import com.projet.agenda.model.User;
import com.projet.agenda.repos.EventRepository;
import com.projet.agenda.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {


    @Autowired
    private UserRepository userRepo;

    @Autowired
    private EventRepository eventRepo;
    // Gérer la base de données des utilisateurs et des évènements
    public List<User> getAllUsers() {
        return (List<User>) userRepo.findAll();
    }

    public List<Event> getAllEvents() {
        return (List<Event>) eventRepo.findAll();
    }

    // Modifier et supprimer des comptes et des évènements
    public void deleteUser(Integer userId) {
        userRepo.deleteById(userId);
    }

    public void deleteEvent(Integer eventId) {
        eventRepo.deleteById(eventId);
    }

    // Gérer les signalements faits par les utilisateurs
    // Add methods here to handle user reports/flags

    // Ajouter/modifier/supprimer un évènement
    public Event saveEvent(Event event) {
        return eventRepo.save(event);
    }

    public Event updateEvent(Event event) {
        // Implement the logic to update the event
        return eventRepo.save(event);
    }

    // Ajouter/modifier/supprimer un utilisateur
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public User updateUser(User user) {
        // Implement the logic to update the user
        return userRepo.save(user);
    }

    public void deleteUserById(Integer userId) {
        userRepo.deleteById(userId);
    }

    // Afficher l’ensemble des événements et les utilisateurs associés
    public List<Event> getAllEventsWithUsers() {
        // Implement logic to fetch events with associated users
        return (List<Event>) eventRepo.findAll(); // This is a placeholder
    }

    // Effectuer une recherche simple ou avancée selon certains critères
    public List<Event> searchEventsByTitle(String keyword) {
        return eventRepo.findAllByTitreContaining(keyword);
    }

//    public List<Event> searchEventsByDate(/* parameters for date search */) {
//        // Implement logic to search events by date
//        return eventRepo.findBy...(); // Placeholder for date search
//    }

}
