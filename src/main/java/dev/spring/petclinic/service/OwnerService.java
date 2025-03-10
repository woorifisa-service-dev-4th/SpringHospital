package dev.spring.petclinic.service;

import dev.spring.petclinic.domain.Owner;
import dev.spring.petclinic.dto.EditOwnerRequest;
import dev.spring.petclinic.dto.OwnerDetailDto;
import dev.spring.petclinic.dto.OwnerDto;
import dev.spring.petclinic.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

import javax.persistence.EntityNotFoundException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;

//    public List<OwnerDto> findOwnersByLastName(String lastName) {
//        return ownerRepository.findByLastNameContaining(lastName).stream()
//                .map(OwnerDto::fromEntity)
//                .collect(Collectors.toList());
//    }

    public List<Owner> findOwnersByLastName(String lastName) {
        return ownerRepository.findByLastNameContaining(lastName);
    }

    public Owner getOwnerDetail(Integer ownerId) {
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new EntityNotFoundException("Owner not found"));
        return owner;
    }

    public void editOwner(Integer ownerId, EditOwnerRequest request) {
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new EntityNotFoundException("Owner not found"));

        owner.setFirstName(request.getFirstName());
        owner.setLastName(request.getLastName());
        owner.setAddress(request.getAddress());
        owner.setCity(request.getCity());
        owner.setTelephone(request.getTelephone());

        ownerRepository.save(owner);
    }

    public void saveOwner(Owner owner){
        ownerRepository.save(owner);
    }

    public List<Owner> findAll(){
        List<Owner> all = ownerRepository.findAll();
        return all;
    }

//    public Owner findById(Long id){
//        ownerRepository.findById(id);
//    }
}

