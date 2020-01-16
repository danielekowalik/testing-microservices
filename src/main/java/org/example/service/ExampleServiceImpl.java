package org.example.service;

import com.demo.mock.server.registration.model.Pet;
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

    @Override
    public Pet getPet(String id) {
        return new Pet();
    }
}
