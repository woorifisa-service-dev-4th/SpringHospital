package dev.spring.petclinic.dto;

import dev.spring.petclinic.domain.Pet;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PetAndVisitsDto {
    private String name;
    private LocalDate birthDate;
    private String type;
    private List<VisitDto> visits;

    public static PetAndVisitsDto fromEntity(Pet pet) {
        PetAndVisitsDto dto = new PetAndVisitsDto();
        dto.setName(pet.getName());
        dto.setBirthDate(pet.getBirthDate());
        dto.setType(pet.getType().getName());
        dto.setVisits(pet.getVisits().stream().map(VisitDto::fromEntity).collect(Collectors.toList()));
        return dto;
    }
}

