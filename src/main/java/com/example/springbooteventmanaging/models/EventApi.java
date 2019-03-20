package com.example.springbooteventmanaging.models;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/events")
@Slf4j
@RequiredArgsConstructor
public class EventApi {
    private final EventService service;

    @GetMapping
    public ResponseEntity<List<Event>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Event eventneu) {
        return ResponseEntity.ok(service.save(eventneu));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> findById(@PathVariable Long id) {
        Optional<Event> stocking = service.findById(id);
        if (!stocking.isPresent()) {
            log.error("Id " + id + " fehlt in Liste");
            ResponseEntity.badRequest().build();
        }
        else if(id == 0) // test one specific number (here: 0)
        {
            log.error("Id 0 wurde angefragt");
        }
        else
        {

        }
        return ResponseEntity.ok(stocking.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event>
    update(@PathVariable Long id, @Valid @RequestBody Event event) {
        if (!service.findById(id).isPresent()) {
            log.error("Id " + id + " fehlt in Liste!");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(service.save(event));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!service.findById(id).isPresent()) {
            log.error("Id " + id + " kann nicht gelöscht werden; Item nicht vorhanden!");
            ResponseEntity.badRequest().build();
        }

        service.deleteById(id);

        return ResponseEntity.ok().build();
    }
}