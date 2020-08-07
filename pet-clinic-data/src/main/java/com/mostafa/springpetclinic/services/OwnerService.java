package com.mostafa.springpetclinic.services;

import com.mostafa.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
