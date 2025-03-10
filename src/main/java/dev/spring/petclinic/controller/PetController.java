package dev.spring.petclinic.controller;


import dev.spring.petclinic.domain.Owner;
import dev.spring.petclinic.domain.PetType;
import dev.spring.petclinic.dto.AddNewPetRequest;
import dev.spring.petclinic.dto.PetAndVisitsDto;
import dev.spring.petclinic.service.OwnerService;
import dev.spring.petclinic.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/owners")
@RequiredArgsConstructor
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;
    private final OwnerService ownerService;

    @GetMapping("/{ownerId}/pets/new")
    public String showAddPetForm(@PathVariable Integer ownerId, Model model) {
        Owner owner = ownerService.getOwnerDetail(ownerId);  // ownerId를 기반으로 Owner 객체 조회
        //model.addAttribute("ownerId", ownerId);
        model.addAttribute("owner", owner);  // Owner 객체를 모델에 추가
        AddNewPetRequest pet = new AddNewPetRequest();  // 새 펫을 추가할 객체
        pet.setNew(true);  // 새 펫 추가 시 new 속성을 true로 설정
        model.addAttribute("pet", pet);  // 새 펫을 추가하기 위한 빈 객체

        List<PetType> types = petService.getAllPetTypes();  // PetType 서비스로부터 타입 목록 가져오기
        model.addAttribute("types", types);

        return "pets/createOrUpdatePetForm";  // Thymeleaf 템플릿 경로
    }

    // 4. 새로운 펫 추가
    @PostMapping("/{ownerId}/pets/new")
    public String addNewPet(@PathVariable Integer ownerId, @ModelAttribute AddNewPetRequest request) {
        // 펫을 추가
        petService.addNewPet(ownerId, request);

        // 펫 추가 후 ownerDetails 페이지로 리다이렉트
        return "redirect:/owners/{ownerId}";  // ownerDetails.html 페이지로 리다이렉트
    }

    // 5. PetsAndVisits 조회
    @GetMapping("/{petId}/visits")
    public PetAndVisitsDto getPetAndVisits(@PathVariable Integer petId) {
        return petService.getPetAndVisits(petId);
    }
}

