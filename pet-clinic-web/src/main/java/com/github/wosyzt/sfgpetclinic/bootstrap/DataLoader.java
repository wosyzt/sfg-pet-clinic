package com.github.wosyzt.sfgpetclinic.bootstrap;

import com.github.wosyzt.sfgpetclinic.model.Owner;
import com.github.wosyzt.sfgpetclinic.model.Vet;
import com.github.wosyzt.sfgpetclinic.services.OwnerService;
import com.github.wosyzt.sfgpetclinic.services.VetService;
import com.github.wosyzt.sfgpetclinic.services.map.OwnerServiceMap;
import com.github.wosyzt.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;

public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Jlaasi");
        owner2.setLastName("Smith");

        ownerService.save(owner2);

        System.out.println("loaded Owners.");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("sam");
        vet1.setLastName("luli");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("luca");
        vet2.setLastName("John");

        vetService.save(vet2);

        System.out.println("loaded vets");
    }
}
