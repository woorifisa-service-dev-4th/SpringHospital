package dev.spring.petclinic.dto;

import dev.spring.petclinic.domain.Visit;
import lombok.Data;

import java.time.LocalDate;

@Data
public class VisitDto {
    private LocalDate visitDate;
    private String description;

    public static VisitDto fromEntity(Visit visit) {
        VisitDto dto = new VisitDto();
        dto.setVisitDate(visit.getVisitDate());
        dto.setDescription(visit.getDescription());
        return dto;
    }
}
