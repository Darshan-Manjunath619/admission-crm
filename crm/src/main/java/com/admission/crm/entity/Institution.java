package com.admission.crm.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "institutions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Institution extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    private String address;

    @Column(nullable = false)
    private String contactEmail;

    private String contactPhone;
}