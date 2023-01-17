package com.example.reservation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TreatmentController {

    TreatmentService treatmentService;

    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping("/home")
    public String allTreatments(Model model){
        model.addAttribute("treatment", treatmentService.showAll());
        return "/home";
    }
}
