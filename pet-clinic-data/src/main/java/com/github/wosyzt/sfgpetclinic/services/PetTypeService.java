package com.github.wosyzt.sfgpetclinic.services;

import com.github.wosyzt.sfgpetclinic.model.PetType;

public interface PetTypeService extends CrudService<PetType, Long> {
    PetType findPetTypeByName(String name);
}
