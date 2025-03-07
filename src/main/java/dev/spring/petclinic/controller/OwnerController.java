package dev.spring.petclinic.controller;

import dev.spring.petclinic.dto.EditOwnerRequest;
import dev.spring.petclinic.dto.OwnerDetailDto;
import dev.spring.petclinic.dto.OwnerDto;
import dev.spring.petclinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    // 1. findOwner (lastName으로 조회)
    @GetMapping
    public List<OwnerDto> findOwners(@RequestParam String lastName) {
        return ownerService.findOwnersByLastName(lastName);
    }

    // 2. owner 상세 조회
    @GetMapping("/{ownerId}")
    public OwnerDetailDto getOwnerDetail(@PathVariable Integer ownerId) {
        return ownerService.getOwnerDetail(ownerId);
    }

    // 3. owner 수정
    @PutMapping("/{ownerId}")
    public void editOwner(@PathVariable Integer ownerId,
                          @RequestBody EditOwnerRequest request) {
        ownerService.editOwner(ownerId, request);
    }
}

