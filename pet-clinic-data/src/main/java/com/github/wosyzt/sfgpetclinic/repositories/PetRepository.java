package com.github.wosyzt.sfgpetclinic.repositories;

import com.github.wosyzt.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
