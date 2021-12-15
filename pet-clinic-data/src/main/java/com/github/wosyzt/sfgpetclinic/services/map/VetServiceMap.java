package com.github.wosyzt.sfgpetclinic.services.map;

import com.github.wosyzt.sfgpetclinic.model.Vet;
import com.github.wosyzt.sfgpetclinic.services.CrudService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    void deleteById(Long id){
        super.deleteById(id);
    }

    @Override
    void delete(Vet object){
        super.delete(object);
    }
}
