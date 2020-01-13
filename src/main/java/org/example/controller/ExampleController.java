package org.example.controller;

import org.example.service.ExampleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    private ExampleServiceImpl exampleService;

    @Autowired
    public ExampleController(ExampleServiceImpl exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping(path = "/dummy/{id}")
    public ResponseEntity<String> getDummy(@PathVariable String id){
        return ResponseEntity.ok(exampleService.getName(id));
    }

}
