package com.mostafa.springpetclinic.services;

import com.mostafa.springpetclinic.model.Vet;


public interface VetService extends CrudService<Vet, Long>{

    Vet findByLastName(String lastName);
}
