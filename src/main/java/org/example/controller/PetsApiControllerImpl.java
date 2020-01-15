package org.example.controller;

import com.demo.mock.server.registration.api.PetsApi;
import com.demo.mock.server.registration.model.Pet;
import com.demo.mock.server.registration.model.Pets;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PetsApiControllerImpl implements PetsApi {

    @Override
    public ResponseEntity<Void> createPets() {
        return null;
    }

    @Override
    public ResponseEntity<Pets> listPets(@Valid Integer limit) {
        Pets pets = new Pets();
        Pet pet = new Pet();
        pet.setId(12L);
        pet.setName("My Cat");
        pet.setTag("weird one");
        pets.add(pet);
        return ResponseEntity.ok(pets);
    }

    @Override
    public ResponseEntity<Pets> showPetById(String petId) {
        Pets pets = new Pets();
        Pet pet = new Pet();
        pet.setId(Long.valueOf(petId));
        pet.setName("My Cat");
        pet.setTag("weird one");
        pets.add(pet);
        return ResponseEntity.ok(pets);
    }
}
