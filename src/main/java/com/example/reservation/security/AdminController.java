package com.example.reservation.security;


import com.example.reservation.user.User;
import com.example.reservation.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    String adminPanel(Model model) {
        List<User> allUsers = userService.findAll();
        model.addAttribute("users", allUsers);
        return "admin";
    }

    @GetMapping("/delete-user")
    String deleteUser(@RequestParam String nick) {
        userService.deleteUserByNick(nick);
        return "redirect:/admin";
    }
}