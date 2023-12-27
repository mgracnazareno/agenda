package com.projet.agenda.controller;

import com.projet.agenda.model.Event;
import com.projet.agenda.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
