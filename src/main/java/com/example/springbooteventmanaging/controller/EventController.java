package com.example.springbooteventmanaging.controller;
import com.example.springbooteventmanaging.models.EventService;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.MediaType;



@RequestMapping("/api")
@RestController
public class EventController
{

    @RequestMapping(value="/RedirectWithView", method=RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ModelAndView myMethod1 (ModelMap modelsT) {

        return new ModelAndView("welcome.jsp",modelsT);
    }

/*
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
    */
}