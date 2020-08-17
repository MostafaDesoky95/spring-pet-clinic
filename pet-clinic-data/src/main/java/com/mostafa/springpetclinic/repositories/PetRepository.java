package com.mostafa.springpetclinic.repositories;

import com.mostafa.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
