package com.wwc.demo.Controller;

import com.wwc.demo.model.Event;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final List<Event> events = new ArrayList<>();

    @GetMapping
    public List<Event> getAllEvents() {
        return events;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable int id) {

        for (Event event : events) {
            if (event.getId() == id) {
                return ResponseEntity.ok(event); 
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public Event addEvent(@RequestBody Event event) {
        events.add(event);
        return event;
    }
}
