package com.mostafa.springpetclinic.bootstrap;

import com.mostafa.springpetclinic.model.Owner;
import com.mostafa.springpetclinic.model.Vet;
import com.mostafa.springpetclinic.services.OwnerService;
import com.mostafa.springpetclinic.services.VetService;
import com.mostafa.springpetclinic.services.map.OwnerServiceMap;
import com.mostafa.springpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new  Owner();
        owner1.setId(1L);
        owner1.setFirstName("Mostafa");
        owner1.setLastName("Desoky");

        ownerService.save(owner1);


        Owner owner2 = new  Owner();
        owner1.setId(2L);
        owner1.setFirstName("Ahmed");
        owner1.setLastName("Mohamed");

        ownerService.save(owner2);

        System.out.println("loaded owners");

        Vet vet1 = new  Vet();
        vet1.setId(1L);
        vet1.setFirstName("Shawky");
        vet1.setLastName("Rabie");

        vetService.save(vet1);

        Vet vet2 = new  Vet();
        vet1.setId(2L);
        vet1.setFirstName("Rady");
        vet1.setLastName("Esmail");

        vetService.save(vet2);

        System.out.println("loaded vets");
    }
}
