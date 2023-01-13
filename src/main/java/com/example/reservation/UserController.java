package com.example.reservation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<User> all = userService.findAll();
        model.addAttribute("users",all);
        return  "home";
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
