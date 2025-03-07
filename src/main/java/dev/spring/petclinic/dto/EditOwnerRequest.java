package dev.spring.petclinic.dto;

import lombok.Data;

@Data
public class EditOwnerRequest {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;
}
