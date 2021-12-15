package com.github.wosyzt.sfgpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {
    T findById(ID id);
    T save(T object);
    Set<T> findAll();
}