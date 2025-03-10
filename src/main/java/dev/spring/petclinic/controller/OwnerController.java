package dev.spring.petclinic.controller;

import dev.spring.petclinic.domain.Owner;
import dev.spring.petclinic.dto.EditOwnerRequest;
<<<<<<< HEAD
import dev.spring.petclinic.dto.FindOwnerDto;
import dev.spring.petclinic.dto.OwnerDetailDto;
=======
>>>>>>> 60d47703054b3d3f2df237e2ebcb5b7a1a8dd6ad
import dev.spring.petclinic.dto.OwnerDto;
import dev.spring.petclinic.repository.OwnerRepository;
import dev.spring.petclinic.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
=======
import org.springframework.validation.BindingResult;
>>>>>>> 60d47703054b3d3f2df237e2ebcb5b7a1a8dd6ad
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
<<<<<<< HEAD
@RequestMapping("/owners")
=======
>>>>>>> 60d47703054b3d3f2df237e2ebcb5b7a1a8dd6ad
@RequiredArgsConstructor
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;
    private final OwnerRepository ownerRepository;

<<<<<<< HEAD
    @GetMapping("/find")
    public String showFindForm(Model model) {
        model.addAttribute("owner", new FindOwnerDto());  // ⭐ 빈 객체 추가
        return "owners/findOwners";
    }

    // 1. findOwner (lastName으로 조회)
    @GetMapping
    public String findOwners(@RequestParam String lastName, Model model) {
        // lastName 파라미터를 이용해 소유자 목록을 조회
        List<Owner> owners = ownerService.findOwnersByLastName(lastName);

        // 조회된 소유자 목록을 모델에 추가
        model.addAttribute("listOwners", owners);
        model.addAttribute("lastName", lastName); // 검색된 lastName을 뷰에 전달

        return "owners/ownersList"; // findOwners.html로 반환
    }

    // 2. owner 상세 조회
    @GetMapping("/{ownerId}")
    public String getOwnerDetail(@PathVariable Integer ownerId, Model model) {
        Owner ownerDetail = ownerService.getOwnerDetail(ownerId);
        model.addAttribute("owner", ownerDetail);  // owner 정보를 모델에 추가
        return "owners/ownerDetails";  // 템플릿 이름 (예: ownerDetail.html)
=======
    @GetMapping("/new")
    public String createOwnerForm(Model model) {
        model.addAttribute("owner", new Owner());
        model.addAttribute("isNew", true); // 신규 등록 여부 확인을 위한 변수 추가
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/new")
    public String processAddOwnerForm(@ModelAttribute("owner") Owner owner,
                                      BindingResult result,
                                      Model model) {
        if (result.hasErrors()) {
            return "owners/ownerForm";
        }

        ownerService.saveOwner(owner);
        List<Owner> all = ownerService.findAll();
        model.addAttribute("listOwners",all);
        return "redirect:/owners/list";
>>>>>>> 60d47703054b3d3f2df237e2ebcb5b7a1a8dd6ad
    }

    @GetMapping("/list")
    public String showOwnerForm(Model model){
        List<Owner> all = ownerService.findAll();
        model.addAttribute("listOwners",all);
        return "/owners/ownersList";
    }

    @GetMapping("/edit/{ownerId}")
    public String updateForm(@PathVariable Integer ownerId, Model model) {
        Optional<Owner> findOwner = ownerRepository.findById(ownerId);

        if (findOwner.isEmpty()) {
            return "redirect:/owners"; // 없는 owner라면 목록으로 리디렉트
        }
        Owner owner = findOwner.get();
        model.addAttribute("owner", owner);
        model.addAttribute("isNew", false); // 기존 데이터 수정이므로 false 설정
        return "owners/createOrUpdateOwnerForm";
    }

    @GetMapping("/ownerDetails/{ownerId}/edit")
    public String updateDetailForm(@PathVariable Integer ownerId, Model model) {
        Optional<Owner> findOwner = ownerRepository.findById(ownerId);

        if (findOwner.isEmpty()) {
            return "redirect:/owners"; // 없는 owner라면 목록으로 리디렉트
        }
        Owner owner = findOwner.get();
        model.addAttribute("owner", owner);
        model.addAttribute("isNew", false); // 기존 데이터 수정이므로 false 설정
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/edit/{ownerId}")
    public String editOwner(@PathVariable Integer ownerId,
                            @ModelAttribute("owner") EditOwnerRequest owner,
                            BindingResult result) {
        if (result.hasErrors()) {
            return "owners/createOrUpdateOwnerForm";
        }

        ownerService.editOwner(ownerId, owner);
        return "redirect:/owners";
    }

    @GetMapping("/find")
    public String findOwners(@RequestParam(value = "lastName", required = false) String lastName, Model model) {
        if (lastName == null || lastName.isBlank()) {
            model.addAttribute("owners", ownerService.findAll()); // 전체 목록 반환
            return "owners/ownersList";
        }

        List<OwnerDto> owners = ownerService.findOwnersByLastName(lastName);

        if (owners.isEmpty()) {
            model.addAttribute("notFound", true);
            return "owners/findOwners";
        } else if (owners.size() == 1) {
            Integer ownerId = owners.get(0).getId(); // ✅ Null 체크 추가
            if (ownerId == null) {
                model.addAttribute("notFound", true);
                return "owners/findOwners";
            }
            return "redirect:/owners/ownerDetails/" + ownerId;
        } else {
            model.addAttribute("owners", owners);
            return "owners/ownersList"; // 여러 명이면 목록 페이지로 이동
        }
    }

    @GetMapping("/ownerDetails/{ownerId}")
    public String ownerDetails(@PathVariable("ownerId") Integer ownerId, Model model) {
        Optional<Owner> owner = ownerRepository.findById(ownerId);

        if (owner.isEmpty()) {
            return "redirect:/owners";
        }

        model.addAttribute("owner", owner.get());
        return "owners/ownerDetails";
    }

}