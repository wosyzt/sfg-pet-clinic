package com.github.wosyzt.sfgpetclinic.services;

import com.github.wosyzt.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
