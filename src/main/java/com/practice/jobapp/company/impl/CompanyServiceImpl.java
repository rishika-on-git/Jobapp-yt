package com.practice.jobapp.company.impl;

import com.practice.jobapp.company.Company;
import com.practice.jobapp.company.CompanyRepository;
import com.practice.jobapp.company.CompanyService;
import com.practice.jobapp.company.dto.request.CreateCompanyRequest;
import com.practice.jobapp.company.dto.response.CompanyResponse;
import com.practice.jobapp.company.mapper.CompanyMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<CompanyResponse> getAllCompanies() {

        return companyRepository.findAll()
                .stream()
                .map(CompanyMapper::toResponse)
                .toList();
    }

    @Override
    public CompanyResponse updateCompanyById(
            Long id,
            CreateCompanyRequest request) {

        Optional<Company> result =
                companyRepository.findById(id);

        if (result.isEmpty()) {
            throw new RuntimeException("Company not found");
        }

        Company existingCompany = result.get();

        existingCompany.setName(request.getName());
        existingCompany.setDescription(request.getDescription());

        Company updatedCompany = companyRepository.save(existingCompany);

        return CompanyMapper.toResponse(updatedCompany);
    }
}