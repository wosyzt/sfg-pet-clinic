package com.github.wosyzt.sfgpetclinic.services;

import com.github.wosyzt.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
