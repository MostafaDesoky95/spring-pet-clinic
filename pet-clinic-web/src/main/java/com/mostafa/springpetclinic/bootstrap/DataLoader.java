package com.mostafa.springpetclinic.bootstrap;

import com.mostafa.springpetclinic.model.Owner;
import com.mostafa.springpetclinic.model.Pet;
import com.mostafa.springpetclinic.model.PetType;
import com.mostafa.springpetclinic.model.Vet;
import com.mostafa.springpetclinic.services.OwnerService;
import com.mostafa.springpetclinic.services.PetTypeService;
import com.mostafa.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType =petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType =petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Mostafa");
        owner1.setLastName("Desoky");
        owner1.setAddress("1245");
        owner1.setCity("Elwasta");
        owner1.setTelephone("0123456789");

        ownerService.save(owner1);

        Pet mostafaPet = new Pet();
        mostafaPet.setPetType(savedCatPetType);
        mostafaPet.setOwner(owner1);
        mostafaPet.setBirthDate(LocalDate.now());
        mostafaPet.setName("RATATA");
        owner1.getPets().add(mostafaPet);


        Owner owner2 = new Owner();
        owner2.setFirstName("Ahmed");
        owner2.setLastName("Mohamed");
        owner2.setAddress("987654");
        owner2.setCity("Shoubra");
        owner2.setTelephone("099871212501");

        ownerService.save(owner2);

        Pet ahmedPet = new Pet();
        mostafaPet.setPetType(savedDogPetType);
        mostafaPet.setOwner(owner2);
        mostafaPet.setBirthDate(LocalDate.now());
        mostafaPet.setName("Doogy");
        owner1.getPets().add(ahmedPet);


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
