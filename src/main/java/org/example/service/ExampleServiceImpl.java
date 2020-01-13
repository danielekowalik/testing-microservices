package org.example.service;

import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class ExampleServiceImpl implements ExampleService{

    public String getName(String id){
        if (id.equalsIgnoreCase("567")){
            throw new NoSuchElementException("BOOM");
        }
        return "Name" + id;
    }

}
