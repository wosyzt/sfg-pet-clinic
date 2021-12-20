package com.github.wosyzt.sfgpetclinic.services.map;

import com.github.wosyzt.sfgpetclinic.model.Owner;
import com.github.wosyzt.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object);
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

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
