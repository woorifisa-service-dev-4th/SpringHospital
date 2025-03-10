package dev.spring.petclinic.repository;

import dev.spring.petclinic.domain.PetType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PetTypeRepository extends JpaRepository<PetType, Integer> {
    @Override
    List<PetType> findAll();

    Optional<PetType> findByName(String name);
}
