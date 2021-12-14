package com.github.wosyzt.sfgpetclinic.services;

import com.github.wosyzt.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
