package com.github.wosyzt.sfgpetclinic.services.map;

import com.github.wosyzt.sfgpetclinic.model.Owner;
import com.github.wosyzt.sfgpetclinic.services.CrudService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {
    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    void deleteById(Long id){
        super.deleteById(id);
    }

    @Override
    void delete(Owner object){
        super.delete(object);
    }
}
