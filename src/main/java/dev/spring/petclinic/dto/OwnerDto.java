package dev.spring.petclinic.dto;

import dev.spring.petclinic.domain.Owner;
import dev.spring.petclinic.domain.Pet;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class OwnerDto {
<<<<<<< HEAD
    private Integer id;
    private String name;
=======
    private Integer id; // ✅ ID 추가
    private String firstName; // ✅ 개별 필드 유지
    private String lastName;
>>>>>>> 60d47703054b3d3f2df237e2ebcb5b7a1a8dd6ad
    private String address;
    private String city;
    private String telephone;
    private List<String> pets;

    public static OwnerDto fromEntity(Owner owner) {
        OwnerDto dto = new OwnerDto();
<<<<<<< HEAD
        dto.setId(owner.getId());
        dto.setName(owner.getFirstName() + " " + owner.getLastName());
=======
        dto.setId(owner.getId()); // ✅ ID 추가
        dto.setFirstName(owner.getFirstName()); // ✅ 개별 필드 저장
        dto.setLastName(owner.getLastName());
>>>>>>> 60d47703054b3d3f2df237e2ebcb5b7a1a8dd6ad
        dto.setAddress(owner.getAddress());
        dto.setCity(owner.getCity());
        dto.setTelephone(owner.getTelephone());
        dto.setPets(owner.getPets().stream()
                .map(Pet::getName) // Pet 이름 리스트 변환
                .collect(Collectors.toList()));
        return dto;
    }
}

