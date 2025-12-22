package com.example.JavaMini.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.JavaMini.model.Event;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")


public class EventController {
        private final List<Event> events = new ArrayList<>();

        @GetMapping
        public List<Event> getAllEvents(){
            return events;
        }

        @PostMapping
        public ResponseEntity<?> addEvent(@RequestBody Event event){
            if(event.getName() == null || event.getName().isEmpty() || event.getCourse() == null || event.getCourse().isEmpty()){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("no null value");
            
            }
            for(Event e : events){
                if(e.getId()==event.getId()){
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("id conflict");

                }

            }
            events.add(event);
            return ResponseEntity.status(HttpStatus.CREATED).body("student");
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> getEventbyId(@PathVariable int id){
            for(Event e : events){
                if(e.getId()==id){
                    return ResponseEntity.status(HttpStatus.OK).body("found Successfully");
                    
                }
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteEventbyId(@PathVariable int id){
            for(Event e : events){
                if(e.getId()==id){
                    events.remove(e);
                    return ResponseEntity.status(HttpStatus.OK).body("deleted Successfully");
                }
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("student not found");
        }

}
