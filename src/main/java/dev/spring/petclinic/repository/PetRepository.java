package dev.spring.petclinic.repository;

import dev.spring.petclinic.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Integer> {
    @Query("SELECT p FROM Pet p LEFT JOIN FETCH p.visits WHERE p.id = :id")
    Optional<Pet> findByIdWithVisits(@Param("id") Integer id);
}

