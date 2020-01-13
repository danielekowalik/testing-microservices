package org.example.controller;

import org.example.service.ExampleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@RestController
public class ExampleController {

    private ExampleServiceImpl exampleService;

    @Autowired
    public ExampleController(ExampleServiceImpl exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping(path = "/dummy/{id}", produces = "application/json")
    public ResponseEntity<String> getDummy(@PathVariable String id){
        try {
            return ResponseEntity.ok(exampleService.getName(id));
        }catch (NoSuchElementException nse){
            //typical Spring 5
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Element Not Found", nse);
        }


    }


}
