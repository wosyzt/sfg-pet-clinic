package com.github.wosyzt.sfgpetclinic.bootstrap;

import com.github.wosyzt.sfgpetclinic.model.Owner;
import com.github.wosyzt.sfgpetclinic.model.PetType;
import com.github.wosyzt.sfgpetclinic.model.Vet;
import com.github.wosyzt.sfgpetclinic.services.OwnerService;
import com.github.wosyzt.sfgpetclinic.services.PetTypeService;
import com.github.wosyzt.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jlaasi");
        owner2.setLastName("Smith");

        ownerService.save(owner2);

        System.out.println("loaded Owners.");

        Vet vet1 = new Vet();
        vet1.setFirstName("sam");
        vet1.setLastName("luli");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("luca");
        vet2.setLastName("John");

        vetService.save(vet2);

        System.out.println("loaded vets");
    }
}
