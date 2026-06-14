
package com.practice.jobapp.company.mapper;

import com.practice.jobapp.company.Company;
import com.practice.jobapp.company.dto.request.CreateCompanyRequest;
import com.practice.jobapp.company.dto.response.CompanyResponse;

public class CompanyMapper {

    public static Company toEntity(CreateCompanyRequest request) {

        Company company = new Company();

        company.setName(request.getName());
        company.setDescription(request.getDescription());

        return company;
    }

    public static CompanyResponse toResponse(Company company) {

        CompanyResponse response = new CompanyResponse();

        response.setId(company.getId());
        response.setName(company.getName());
        response.setDescription(company.getDescription());

        return response;
    }
}