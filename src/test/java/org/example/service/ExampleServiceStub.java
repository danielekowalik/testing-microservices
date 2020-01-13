package org.example.service;


import java.util.NoSuchElementException;


public class ExampleServiceStub implements ExampleService{

    @Override
    public String getName(String id) {
        if (id.equalsIgnoreCase("567")){
            throw new NoSuchElementException("BOOM");
        }
        return "Name"+id;
    }
}
