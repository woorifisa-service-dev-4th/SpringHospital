package dev.spring.petclinic.controller;

import dev.spring.petclinic.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;

//    @GetMapping("")
//    public String
}