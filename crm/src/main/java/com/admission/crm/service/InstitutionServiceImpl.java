package com.admission.crm.service;

import com.admission.crm.dto.InstitutionRequestDTO;
import com.admission.crm.entity.Institution;
import com.admission.crm.exception.BusinessException;
import com.admission.crm.exception.ResourceNotFoundException;
import com.admission.crm.repository.InstitutionRepository;
import com.admission.crm.service.InstitutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstitutionServiceImpl implements InstitutionService {

    private final InstitutionRepository institutionRepository;

    @Override
    public Institution createInstitution(InstitutionRequestDTO request) {

        // Business Rule: Code must be unique
        if (institutionRepository.existsByCode(request.getCode())) {
            throw new BusinessException("Institution code already exists.");
        }

        // Business Rule: Name must be unique
        if (institutionRepository.existsByName(request.getName())) {
            throw new BusinessException("Institution name already exists.");
        }

        Institution institution = Institution.builder()
                .name(request.getName())
                .code(request.getCode())
                .address(request.getAddress())
                .contactEmail(request.getContactEmail())
                .contactPhone(request.getContactPhone())
                .build();

        return institutionRepository.save(institution);
    }

    @Override
    public Institution getInstitutionById(Long id) {
        return institutionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Institution not found with ID: " + id));
    }

    @Override
    public List<Institution> getAllInstitutions() {
        return institutionRepository.findAll();
    }

    @Override
    public void deleteInstitution(Long id) {

        Institution institution = getInstitutionById(id);

        // Future safeguard: check if campuses exist before deleting
        institutionRepository.delete(institution);
    }
}