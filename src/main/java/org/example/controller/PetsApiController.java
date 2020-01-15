package org.example.controller;

import com.demo.mock.server.registration.api.PetsApi;
import com.demo.mock.server.registration.model.Pets;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PetsApiController implements PetsApi {

    @Override
    public ResponseEntity<Void> createPets() {
        return null;
    }

    @Override
    public ResponseEntity<Pets> listPets(@Valid Integer limit) {
        return null;
    }

    @Override
    public ResponseEntity<Pets> showPetById(String petId) {
        return null;
    }
}
