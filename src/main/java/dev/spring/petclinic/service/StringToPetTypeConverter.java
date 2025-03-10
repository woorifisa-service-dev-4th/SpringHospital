package dev.spring.petclinic.service;

import dev.spring.petclinic.domain.PetType;
import dev.spring.petclinic.repository.PetTypeRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StringToPetTypeConverter implements Converter<String, PetType> {

    @Autowired
    private PetTypeRepository petTypeRepository;

    @Override
    public PetType convert(String source) {
        return petTypeRepository.findByName(source)
                .orElseThrow(() -> new IllegalArgumentException("Invalid PetType: " + source));
    }
}
