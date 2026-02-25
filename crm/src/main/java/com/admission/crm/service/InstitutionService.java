package com.admission.crm.service;

import com.admission.crm.dto.InstitutionRequestDTO;
import com.admission.crm.entity.Institution;

import java.util.List;

public interface InstitutionService {

    Institution createInstitution(InstitutionRequestDTO request);

    Institution getInstitutionById(Long id);

    List<Institution> getAllInstitutions();

    void deleteInstitution(Long id);
}