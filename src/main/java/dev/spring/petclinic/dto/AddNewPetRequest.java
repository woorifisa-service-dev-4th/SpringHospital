package dev.spring.petclinic.dto;

import dev.spring.petclinic.domain.PetType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddNewPetRequest {
    private String name;
    private LocalDate birthDate;
    private PetType type;
}
