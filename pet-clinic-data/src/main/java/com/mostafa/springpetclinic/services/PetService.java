package com.mostafa.springpetclinic.services;

import com.mostafa.springpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();

}
