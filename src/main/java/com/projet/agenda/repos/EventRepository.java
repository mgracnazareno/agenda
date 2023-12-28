package com.projet.agenda.repos;

import com.projet.agenda.model.Event;
import com.projet.agenda.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

    //a method that search the creator of an Event
    @Query("SELECT e.createdBy FROM Event e WHERE e.id= :id")
    public User findCreatorEvents(@Param("id") Integer id);

    @Query("SELECT e FROM Event e")
    public List<Event> findAllEvents();

    // Method to display all events based on a keyword in the event title
    @Query("SELECT e FROM Event e WHERE e.titre LIKE %?1%")
    public List<Event> findAllByTitleContaining(String keyword);
    void deleteById(Integer eventId);

    // Find event by ID
    //a method that find Event by Id
    @Query("SELECT e FROM Event e WHERE e.id = :id")
    public Optional<Event> findByEventId(@Param("id") Integer id);
//
//    //find event by Title
//    Optional<Event> findByTitre(String keyword);
//
    //find event by location
    List<Event> findByLieu(String lieu);
//
    //find event by DateRange
    List<Event> findByHeureDebutBetween(LocalTime heureDebut, LocalTime heureFin);


}
