
package dev.spring.petclinic.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "types")
public class PetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return this.name;
    }

}

