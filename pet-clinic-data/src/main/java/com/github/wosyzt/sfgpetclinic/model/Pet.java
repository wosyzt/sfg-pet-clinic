package com.github.wosyzt.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity{
    @Builder
    public Pet(Long id,
               String name, Owner owner, PetType petType,
               LocalDate birthDate, Set<Visit> visits) {
        super(id);
        this.name = name;
        this.owner = owner;
        this.petType = petType;
        this.birthDate = birthDate;
        this.visits = visits;
    }

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();



    @Override
    public String toString() {
        return name;
    }


}
