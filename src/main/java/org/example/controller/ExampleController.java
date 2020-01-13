package org.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping(path = "/dummy")
    public ResponseEntity<String> getDummy(){
        return ResponseEntity.ok("Dummy");
    }

}
