package com.mostafa.springpetclinic.repositories;

import com.mostafa.springpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
