package com.admission.crm.controller;

import com.admission.crm.dto.ApiResponse;
import com.admission.crm.dto.InstitutionRequestDTO;
import com.admission.crm.entity.Institution;
import com.admission.crm.service.InstitutionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institutions")
@RequiredArgsConstructor
public class InstitutionController {

    private final InstitutionService institutionService;

    @PostMapping
    public ApiResponse<Institution> createInstitution(
            @Valid @RequestBody InstitutionRequestDTO request) {

        Institution institution = institutionService.createInstitution(request);
        return ApiResponse.success(institution, "Institution created successfully");
    }

    @GetMapping("/{id}")
    public ApiResponse<Institution> getInstitution(@PathVariable Long id) {

        Institution institution = institutionService.getInstitutionById(id);
        return ApiResponse.success(institution, "Institution fetched successfully");
    }

    @GetMapping
    public ApiResponse<List<Institution>> getAllInstitutions() {

        List<Institution> institutions = institutionService.getAllInstitutions();
        return ApiResponse.success(institutions, "All institutions fetched successfully");
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteInstitution(@PathVariable Long id) {

        institutionService.deleteInstitution(id);
        return ApiResponse.success(null, "Institution deleted successfully");
    }
}