package com.example.reservation.web;

import com.example.reservation.treatment.TreatmentService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    private final TreatmentService treatmentService;

    public LoginController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @RequestMapping("/login")
    String loginForm() {
        return "login";
    }

    @GetMapping("/")
    String welcomePage(Model model) {
        model.addAttribute("treatmentWithoutPrice", treatmentService.showAll());
        return "index";
    }
}