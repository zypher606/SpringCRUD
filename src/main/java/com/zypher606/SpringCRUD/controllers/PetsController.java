package com.zypher606.SpringCRUD.controllers;

import com.zypher606.SpringCRUD.models.Pets;
import com.zypher606.SpringCRUD.repositories.PetsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by zypher606 on 12/10/19.
 */

@RestController
@RequestMapping("/pets")
public class PetsController {
    @Autowired
    private PetsRepository petsRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Pets> getAllPets() {
        return petsRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pets getPetById(@PathVariable("id") ObjectId id) {
        return petsRepository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyPetById(@PathVariable("id") ObjectId id, @Valid
    @RequestBody Pets pets) {
        pets.set_id(id);
        petsRepository.save(pets);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Pets createPet(@Valid @RequestBody Pets pets) {
        pets.set_id(ObjectId.get());
        petsRepository.save(pets);
        return pets;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePet(@PathVariable ObjectId id) {
        petsRepository.delete(petsRepository.findBy_id(id));
    }
}
