package org.example.service;


import com.demo.mock.server.registration.model.Pet;

import java.util.NoSuchElementException;


public class ExampleServiceStub implements ExampleService{

    @Override
    public String getName(String id) {
        if (id.equalsIgnoreCase("567")){
            throw new NoSuchElementException("BOOM");
        }
        return "Name"+id;
    }

    @Override
    public Pet getPet(String id) {
        return null;
    }
}
