package dev.spring.petclinic.controller;

import dev.spring.petclinic.dto.AddNewPetRequest;
import dev.spring.petclinic.dto.PetAndVisitsDto;
import dev.spring.petclinic.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    // 4. 새로운 펫 추가
    @PostMapping("/{ownerId}")
    public void addNewPet(@PathVariable Integer ownerId,
                          @RequestBody AddNewPetRequest request) {
        petService.addNewPet(ownerId, request);
    }

    // 5. PetsAndVisits 조회
    @GetMapping("/{petId}/visits")
    public PetAndVisitsDto getPetAndVisits(@PathVariable Integer petId) {
        return petService.getPetAndVisits(petId);
    }
}
