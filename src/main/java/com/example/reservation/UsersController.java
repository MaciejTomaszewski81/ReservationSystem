package com.example.reservation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsersController {

    private UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Users> all = usersRepository.findAll();
        model.addAttribute("users",all);
        return  "home";
    }

    @GetMapping("/add-user")
    public String addUser(){
        return "adduser";
    }
}
