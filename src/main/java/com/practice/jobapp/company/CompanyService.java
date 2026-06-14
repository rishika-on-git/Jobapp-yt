package com.practice.jobapp.company;

import com.practice.jobapp.company.dto.request.CreateCompanyRequest;
import com.practice.jobapp.company.dto.response.CompanyResponse;

import java.util.List;

public interface CompanyService {

    List<CompanyResponse> getAllCompanies();

    CompanyResponse updateCompanyById(Long id, CreateCompanyRequest company);

}
