package com.mostafa.springpetclinic.bootstrap;

import com.mostafa.springpetclinic.model.*;
import com.mostafa.springpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtiesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0)
        loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType =petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType =petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtiesService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtiesService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtiesService.save(dentistry);

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

        Visit catVisit = new Visit();
        catVisit.setPet(mostafaPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("She needs some fast medications");

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
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new  Vet();
        vet2.setFirstName("Rady");
        vet2.setLastName("Esmail");
        vet2.getSpecialities().add(savedDentistry);

        vetService.save(vet2);

        System.out.println("loaded vets");
    }
}
