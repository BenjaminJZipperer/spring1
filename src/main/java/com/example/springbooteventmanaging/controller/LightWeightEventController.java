package com.example.springbooteventmanaging.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Aufgabe(n): Rendern der HTMl Seite 
@Controller
public class LightWeightEventController {
    @GetMapping("/")
    public String listAllEventsOnStart(){
		// Verweis auf das Template "events"
        return "events_page";
    }
}