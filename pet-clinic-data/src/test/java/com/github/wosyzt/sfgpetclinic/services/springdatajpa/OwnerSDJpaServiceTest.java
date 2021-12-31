package com.github.wosyzt.sfgpetclinic.services.springdatajpa;

import com.github.wosyzt.sfgpetclinic.model.Owner;
import com.github.wosyzt.sfgpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner owner;

    private final Long NONE_EXIST_ID = 10L;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1L).lastName("Smith").build();
    }

    @Test
    void findById() {
        Owner own1 = ownerSDJpaService.findById(owner.getId());
        assertNotNull(own1);
        assertEquals(owner.getId(), own1.getId());
        verify(ownerRepository, times(1)).findById(anyLong());
    }

    @Test
    void findByIdNotFound() {
        Owner own1 = ownerSDJpaService.findById(NONE_EXIST_ID);
        verify(ownerRepository, times(1)).findById(anyLong());
        assertNull(own1);
    }

    @Test
    void save() {
        Owner savedOwner = ownerSDJpaService.save(owner);
        verify(ownerRepository).save(any());
        assertNotNull(savedOwner);
        assertEquals(savedOwner.getId(), owner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        Owner owner2 = Owner.builder().id(2L).build();
        Owner owner3 = Owner.builder().id(3L).build();
        owners.add(owner2);
        owners.add(owner3);
        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> all = ownerSDJpaService.findAll();
        verify(ownerRepository).findAll();
        assertNotNull(all);
        assertEquals(2, all.size());

    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(owner.getId());
        verify(ownerRepository).deleteById(anyLong());

    }

    @Test
    void delete() {
        ownerSDJpaService.delete(owner);
        verify(ownerRepository).delete(any());

    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        Owner byLastName = ownerSDJpaService.findByLastName(owner.getLastName());
        verify(ownerRepository).findByLastName(anyString());
        assertNotNull(byLastName);
        assertEquals(owner.getId(), byLastName.getId());
    }
}