package dev.spring.petclinic.dto;

import dev.spring.petclinic.domain.Owner;
import dev.spring.petclinic.domain.Pet;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class OwnerDto {
    private String name;
    private String address;
    private String city;
    private String telephone;
    private List<String> pets;

    public static OwnerDto fromEntity(Owner owner) {
        OwnerDto dto = new OwnerDto();
        dto.setName(owner.getFirstName() + " " + owner.getLastName());
        dto.setAddress(owner.getAddress());
        dto.setCity(owner.getCity());
        dto.setTelephone(owner.getTelephone());
        dto.setPets(owner.getPets().stream().map(Pet::getName).collect(Collectors.toList()));
        return dto;
    }
}

