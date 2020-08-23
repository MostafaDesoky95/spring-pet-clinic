package com.mostafa.springpetclinic.services.springdatajpa;

import com.mostafa.springpetclinic.model.Owner;
import com.mostafa.springpetclinic.repositories.OwnerRepository;
import com.mostafa.springpetclinic.repositories.PetRepository;
import com.mostafa.springpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    public static final String LastName = "Desoky";
     @Mock
     OwnerRepository ownerRepository;
     @Mock
     PetRepository petRepository;
     @Mock
     PetTypeRepository petTypeRepository;
     @InjectMocks
     OwnerJpaService ownerJpaService;

     Owner savedOwner;

    @BeforeEach
    void setUp() {
         savedOwner = Owner.builder().id(1L).lastName(LastName).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(savedOwner);

        Owner owner = ownerJpaService.findByLastName(LastName);
        assertEquals(LastName,owner.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners =new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> ownerSet = ownerJpaService.findAll();

        assertNotNull(ownerSet);
        assertEquals(2,ownerSet.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(savedOwner));

        Owner owner = ownerJpaService.findById(1L);

        assertNotNull(owner);
    }
    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerJpaService.findById(1L);

        assertNull(owner);


    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(savedOwner);

        Owner owner = ownerJpaService.save(ownerToSave);

        assertNotNull(owner);
    }

    @Test
    void delete() {
        ownerJpaService.delete(savedOwner);

        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerJpaService.deleteById(savedOwner.getId());

        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}