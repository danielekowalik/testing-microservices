package org.example.service;

import com.demo.mock.server.registration.model.Pet;

public interface ExampleService {
    String getName(String id);
    Pet getPet(String id);
}
