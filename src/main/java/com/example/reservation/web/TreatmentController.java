package com.example.reservation.web;

import com.example.reservation.treatment.TreatmentService;
import com.example.reservation.WelcomeMessageService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TreatmentController {

    private final WelcomeMessageService welcomeMessageService;
    private final TreatmentService treatmentService;

    public TreatmentController(WelcomeMessageService welcomeMessageService, TreatmentService treatmentService) {
        this.welcomeMessageService = welcomeMessageService;
        this.treatmentService = treatmentService;
    }

    @GetMapping("/home")
    public String allTreatments(Authentication authentication, Model model){
        String welcomeMessage = welcomeMessageService.getWelcomeMessage();
        model.addAttribute("welcomeMessage",welcomeMessage);
        model.addAttribute("username", authentication.getName());
        model.addAttribute("treatment", treatmentService.showAll());
        return "home";
    }
}