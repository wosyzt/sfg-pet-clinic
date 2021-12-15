package com.github.wosyzt.sfgpetclinic.services.map;

import com.github.wosyzt.sfgpetclinic.model.Pet;
import com.github.wosyzt.sfgpetclinic.services.CrudService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    void deleteById(Long id){
        super.deleteById(id);
    }

    @Override
    void delete(Pet object){
        super.delete(object);
    }
}
