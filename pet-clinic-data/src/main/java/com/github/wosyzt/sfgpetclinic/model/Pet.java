package com.github.wosyzt.sfgpetclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity{
    private Owner owner;
    private PetType petType;
    private LocalDate birthDate;

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
