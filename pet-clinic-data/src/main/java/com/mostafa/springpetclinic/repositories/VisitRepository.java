package com.mostafa.springpetclinic.repositories;

import com.mostafa.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
