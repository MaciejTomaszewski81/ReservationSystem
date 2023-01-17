package com.example.reservation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String allUsers(Model model) {
        model.addAttribute("user",userService.findAll());
        return "users";
    }

    @GetMapping("/add-user")
    public String addUser(){
        return "adduser";
    }

    @PostMapping("/add-user")
    public String addUser(User user){
        userService.addUser(user);
        return "redirect:/";
    }
}
