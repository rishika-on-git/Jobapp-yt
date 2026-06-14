package com.practice.jobapp.company.impl;

import com.practice.jobapp.company.Company;
import com.practice.jobapp.company.CompanyRepository;
import com.practice.jobapp.company.CompanyService;
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
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company updateCompanyById(Long id, Company company) {

        Optional<Company> result =  companyRepository.findById(id);

        if(result.isEmpty()) {
            throw new RuntimeException("Company not found");
        }

        Company existingCompany = result.get();

        existingCompany.setName(company.getName());
        existingCompany.setDescription(company.getDescription());

        return companyRepository.save(existingCompany);
    }
}
