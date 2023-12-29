package com.projet.agenda.controller;

import com.projet.agenda.model.Authorities;
import com.projet.agenda.model.User;
import com.projet.agenda.service.UserNotFoundException;
import com.projet.agenda.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService uService){
        userService = uService;
    }

    @GetMapping("/list")
    public String listUsers(Model model){
        //get the User from the database
        List<User> listUsers = userService.afficherUsers();
        //add to the spring model
        model.addAttribute("listUsers", listUsers);
        return "users/list-users";

    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        //create the model attribute to bind form data
        User user = new User();
        user.setEnabled(true);
        model.addAttribute("user", user);
        List<Authorities> listeAuthorities = userService.afficherRoles();
        model.addAttribute("listeRole", listeAuthorities);
        return "/users/user-form";
    }

    @GetMapping("showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") Integer id, Model model) throws UserNotFoundException {
        //get the user from the service
        Optional<User> user = userService.findUserById(id);
        //set the user in the model to prepopulate the form
        model.addAttribute("user", user);
        //send over to the form
        return "/users/user-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("userId") Integer id) throws UserNotFoundException {
        //delete user
        userService.deleteUserById(id);
        //redirect to the /users/list
        return "redirect:/users/list";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes){
        String fullName = user.getPrenom() + " " + user.getNom();
        redirectAttributes.addFlashAttribute("message", "L'utilisateur: " + fullName + " a été ajouté avec success");
        //save the user
        userService.ajouterUser(user);
        //use a redirect to prevent duplicate submissions
        return "redirect:/users/list";
    }

    @GetMapping("/search")
    public String searchUsers(@RequestParam(value="keyword", required = false)String keyword, Model model){
        List<User> listUsers = userService.findByPrenomAndNom(keyword);
        model.addAttribute("listUsers", listUsers);
        return "redirect:/users/list";
    }



}
