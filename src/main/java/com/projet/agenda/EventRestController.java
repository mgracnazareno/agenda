package com.projet.agenda;

import com.projet.agenda.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/events")
public class EventRestController {

//    @Autowired
//    EventService eventService;
//    @PostMapping("/check_event")
//    public String verifierDoublonEventName(@Param("eventId")String titre){
//        return eventService.isEventUnique
//    }
}
