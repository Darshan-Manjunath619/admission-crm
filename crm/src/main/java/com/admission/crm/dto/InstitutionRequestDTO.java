package com.admission.crm.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstitutionRequestDTO {

    @NotBlank(message = "Institution name is required")
    @Size(max = 100)
    private String name;

    @NotBlank(message = "Institution code is required")
    @Size(max = 50)
    private String code;

    private String address;

    @Email(message = "Invalid email format")
    private String contactEmail;

    private String contactPhone;
}