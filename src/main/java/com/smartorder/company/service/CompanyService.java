package com.smartorder.company.service;

import com.smartorder.company.dto.request.SaveCompanyRequest;
import com.smartorder.company.dto.request.UpdateCompanyRequest;
import com.smartorder.company.dto.response.SaveCompanyResponse;
import com.smartorder.company.dto.response.UpdateCompanyResponse;
import com.smartorder.company.entity.Company;

public interface CompanyService {

    SaveCompanyResponse saveCompany(SaveCompanyRequest request);

    UpdateCompanyResponse updateCompany(UpdateCompanyRequest request);

    Company findById(Long companyId);
}
