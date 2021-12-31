package com.github.wosyzt.sfgpetclinic.services.map;

import com.github.wosyzt.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    private Long longId;
    private String lastName;

    @BeforeEach
    void setUp() {
        longId = 1L;
        lastName = "Smith";
        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
        ownerServiceMap.save(new Owner().builder().id(longId).lastName(lastName).build());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(longId);
        assertNotNull(owner);
        assertEquals(longId, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner savedOwner = ownerServiceMap.save(new Owner().builder().id(id).build());
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId(){
        Owner savedOwner = ownerServiceMap.save(new Owner().builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertNotNull(owners);
        assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(longId);
        Owner owner = ownerServiceMap.findById(longId);
        assertNull(owner);
    }

    @Test
    void delete() {
        Owner owner = new Owner().builder().id(longId).build();
        ownerServiceMap.delete(owner);
        Owner deletedOwner = ownerServiceMap.findById(longId);
        assertNull(deletedOwner);
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName(lastName);
        assertNotNull(owner);
        assertEquals(longId, owner.getId());
    }
}