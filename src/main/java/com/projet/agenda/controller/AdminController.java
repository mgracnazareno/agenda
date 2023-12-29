package com.projet.agenda.controller;

import com.projet.agenda.model.Admin;
import com.projet.agenda.model.Event;
import com.projet.agenda.model.User;
import com.projet.agenda.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admins")
public class AdminController {
    private AdminService adminService;

    public AdminController(AdminService adService){
        this.adminService = adService;
    }

    // Endpoint to retrieve all users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = adminService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Endpoint to retrieve all events
    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = adminService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    // Endpoint to delete a user by ID
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId) {
        adminService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

    // Endpoint to delete an event by ID
    @DeleteMapping("/events/{eventId}")
    public ResponseEntity<String> deleteEvent(@PathVariable Integer eventId) {
        adminService.deleteEvent(eventId);
        return new ResponseEntity<>("Event deleted successfully", HttpStatus.OK);
    }

}
