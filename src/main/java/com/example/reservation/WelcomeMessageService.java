package com.example.reservation;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class WelcomeMessageService {
    public String getWelcomeMessage() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String welcomeMessage = "Cześć ";
        return welcomeMessage + username;
    }
}
