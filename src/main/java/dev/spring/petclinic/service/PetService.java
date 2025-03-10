package dev.spring.petclinic.service;

import dev.spring.petclinic.domain.Owner;
import dev.spring.petclinic.domain.Pet;
import dev.spring.petclinic.domain.PetType;
import dev.spring.petclinic.dto.AddNewPetRequest;
import dev.spring.petclinic.dto.PetAndVisitsDto;
import dev.spring.petclinic.repository.OwnerRepository;
import dev.spring.petclinic.repository.PetRepository;
import dev.spring.petclinic.repository.PetTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public void addNewPet(Integer ownerId, AddNewPetRequest request) {
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new EntityNotFoundException("Owner not found"));

        Pet pet = new Pet();
        pet.setName(request.getName());
        pet.setBirthDate(request.getBirthDate());
        pet.setType(request.getType());
        pet.setOwner(owner);

        petRepository.save(pet);
    }

    public PetAndVisitsDto getPetAndVisits(Integer petId) {
        Pet pet = petRepository.findByIdWithVisits(petId)
                .orElseThrow(() -> new EntityNotFoundException("Pet not found"));
        return PetAndVisitsDto.fromEntity(pet);
    }

    public List<PetType> getAllPetTypes() {
        return petTypeRepository.findAll();
    }

}

