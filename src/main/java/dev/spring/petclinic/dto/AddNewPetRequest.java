package dev.spring.petclinic.dto;

import dev.spring.petclinic.domain.PetType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class AddNewPetRequest {
    private Integer id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private PetType type;
    private boolean isNew;
}
