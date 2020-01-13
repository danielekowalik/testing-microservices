package org.example.service;

import org.springframework.stereotype.Component;

@Component
public class ExampleServiceImpl implements ExampleService{

    public String getName(String id){
        return "Name" + id;
    }

}
