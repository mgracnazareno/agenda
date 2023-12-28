package com.projet.agenda.controller;

import com.projet.agenda.model.Event;
import com.projet.agenda.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    private EventService eventService;
    public EventController(EventService eService){eventService = eService;}

    @GetMapping("/list")
    public String listEvents(Model model){
        //get the Event from database
        List<Event> listEvents = eventService.findAllEvents();
        //add to the spring model
        model.addAttribute("listEvents", listEvents);
        return "/events/list-events";
    }

    @GetMapping("/showFormAddEvent")
    public String showFormAddEvent(Model model){
        //create model attribute to bind form data
        Event event = new Event();
        model.addAttribute("event", event);
        return "/events/event-form";
    }

    @PostMapping("/saveEvent")
    public String saveEvent(@ModelAttribute("event") Event event) {
        eventService.ajouterEvent(event);
        return "redirect:/events/list"; // Redirect to home page or another URL
    }
}
