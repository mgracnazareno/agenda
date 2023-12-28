package com.projet.agenda.service;

import com.projet.agenda.model.Event;
import com.projet.agenda.model.User;
import com.projet.agenda.repos.EventRepository;
import com.projet.agenda.repos.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepo;

    @Autowired
    private UserRepository userRepo;

    public EventService() throws ParseException {
    }

    //method to create event
    public Event saveEvent(Event event) {
        return eventRepo.save(event);
    }

    // Update event by ID
    public Event updateEvent(Integer eventId, Event updatedEventDetails) {
        Event existingEvent = eventRepo.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("Event not found with ID: " + eventId));

        // Update the existing event with the new details
        existingEvent.setTitre(updatedEventDetails.getTitre());
        existingEvent.setHeureDebut(updatedEventDetails.getHeureDebut());
        existingEvent.setHeureFin(updatedEventDetails.getHeureFin());
        existingEvent.setLieu(updatedEventDetails.getLieu());
        existingEvent.setCommentaire(updatedEventDetails.getCommentaire());

        // Save the updated event
        return eventRepo.save(existingEvent);
    }

    //delete even
    public void deleteEventById(Integer id){
        eventRepo.deleteById(id);
    }

    // Delete event by ID and return the deleted event
    public Event deleteEvent(Integer eventId) {
        Optional<Event> eventOptional = eventRepo.findById(eventId);
        if (eventOptional.isPresent()) {
            Event event = eventOptional.get();
            eventRepo.deleteById(eventId);
            return event;
        } else {
            // Handle if the event with the given ID is not found
            return null; // Or throw an exception or handle according to your logic
        }
    }

    //Find event by Title
    public List<Event> findByLieu(String lieu){
        return eventRepo.findByLieu(lieu);
    }

    //Find event by DateRange
    public List<Event> findByHeureDebutBetween(LocalTime heureDebut, LocalTime heureFin){
        return eventRepo.findByHeureDebutBetween(heureDebut, heureFin);
    }

    //display all events
    public List<Event> findAllEvents(){
        return eventRepo.findAllEvents();
    }

    //save event
    public Event ajouterEvent(Event event ){
        return eventRepo.save(event);
    }

    public List<Event> getAllEvents(){return  eventRepo.findAllEvents();}


    // Assuming you're receiving a date string from user input
    String dateStringFromUser = "2023-12-25";




}
