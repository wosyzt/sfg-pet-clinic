package com.github.wosyzt.sfgpetclinic.bootstrap;

import com.github.wosyzt.sfgpetclinic.model.Owner;
import com.github.wosyzt.sfgpetclinic.model.Pet;
import com.github.wosyzt.sfgpetclinic.model.PetType;
import com.github.wosyzt.sfgpetclinic.model.Vet;
import com.github.wosyzt.sfgpetclinic.services.OwnerService;
import com.github.wosyzt.sfgpetclinic.services.PetTypeService;
import com.github.wosyzt.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1231231212");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jlaasi");
        owner2.setLastName("Smith");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("1231231212");

        Pet fionasCat = new Pet();
        fionasCat.setName("Just cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);

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
