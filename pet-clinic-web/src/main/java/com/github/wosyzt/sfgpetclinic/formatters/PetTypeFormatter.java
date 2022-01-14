package com.github.wosyzt.sfgpetclinic.formatters;

import com.github.wosyzt.sfgpetclinic.model.PetType;
import com.github.wosyzt.sfgpetclinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {
    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        PetType finded = petTypeService.findPetTypeByName(text);
        if(finded == null){
            throw new ParseException("type not found", 0);
        }
        return finded;
    }

    @Override
    public String print(PetType object, Locale locale) {
        return object.getName();
    }
}
