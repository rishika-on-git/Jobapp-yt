package com.practice.jobapp.company;

import com.practice.jobapp.company.dto.request.CreateCompanyRequest;
import com.practice.jobapp.company.dto.response.CompanyResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyResponse>> getCompanies() {

        List<CompanyResponse> companies = companyService.getAllCompanies();

        return ResponseEntity.ok(companies);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyResponse> updateCompany(
            @PathVariable Long id,
            @RequestBody CreateCompanyRequest request) {

        CompanyResponse updatedCompany = companyService.updateCompanyById(id, request);

        return ResponseEntity.ok(updatedCompany);
    }
}