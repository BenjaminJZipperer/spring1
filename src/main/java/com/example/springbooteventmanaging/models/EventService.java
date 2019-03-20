package com.example.springbooteventmanaging.models;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class EventService
{
    private final EventRepository register;

    public List<Event> findAll() //
     {
         // gebe alle Treffer zurück (ungefiltert)
        return register.findAll();
    }

    public Optional<Event> findById(Long id)
    {
        // gebe Einzeltreffer zurück
        return register.findById(id);
    }
    // Neuen Event im Reository anlegen
    public Event save(Event stocking) {
        return register.save(stocking);
    }

    public void deleteById(Long id) {
        register.deleteById(id);
    }
}
