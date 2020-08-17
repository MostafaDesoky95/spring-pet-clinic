package com.mostafa.springpetclinic.repositories;

import com.mostafa.springpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner , Long> {
}
