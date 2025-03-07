package dev.spring.petclinic.dto;

import dev.spring.petclinic.domain.Owner;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class OwnerDetailDto {
    private String name;
    private String address;
    private String city;
    private String telephone;
    private List<PetAndVisitsDto> pets;

    public static OwnerDetailDto fromEntity(Owner owner) {
        OwnerDetailDto dto = new OwnerDetailDto();
        dto.setName(owner.getFirstName() + " " + owner.getLastName());
        dto.setAddress(owner.getAddress());
        dto.setCity(owner.getCity());
        dto.setTelephone(owner.getTelephone());
        dto.setPets(owner.getPets().stream().map(PetAndVisitsDto::fromEntity).collect(Collectors.toList()));
        return dto;
    }
}

