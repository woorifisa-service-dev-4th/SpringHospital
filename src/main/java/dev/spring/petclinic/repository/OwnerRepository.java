package dev.spring.petclinic.repository;

import dev.spring.petclinic.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    List<Owner> findByLastNameContaining(String lastName);

}

