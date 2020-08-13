package com.mostafa.springpetclinic.bootstrap;

import com.mostafa.springpetclinic.model.Owner;
import com.mostafa.springpetclinic.model.Vet;
import com.mostafa.springpetclinic.services.OwnerService;
import com.mostafa.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Mostafa");
        owner1.setLastName("Desoky");

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Ahmed");
        owner2.setLastName("Mohamed");

        ownerService.save(owner2);

        System.out.println("loaded owners");

        Vet vet1 = new  Vet();
        vet1.setFirstName("Shawky");
        vet1.setLastName("Rabie");

        vetService.save(vet1);

        Vet vet2 = new  Vet();
        vet2.setFirstName("Rady");
        vet2.setLastName("Esmail");

        vetService.save(vet2);

        System.out.println("loaded vets");
    }
}
