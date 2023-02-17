package com.example.reservation.web;


import com.example.reservation.user.User;
import com.example.reservation.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        List<User> allUsers = userService.findAllWithoutAdminUser();
        model.addAttribute("users", allUsers);
        return "admin";
    }

    @PostMapping("/change-password")
    String changePassword(@RequestParam String newPassword){
       userService.changePassword(newPassword);
       return "redirect:/index";
    }
//    @GetMapping("/delete-user")
//    String deleteUser(@RequestParam String nick) {
//        userService.deleteUserByNick(nick);
//        return "redirect:/admin";
//    }

    @GetMapping("/deleteUser/{id}")
    String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }
}