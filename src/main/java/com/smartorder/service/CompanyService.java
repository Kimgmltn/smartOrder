package com.smartorder.service;

import com.smartorder.dto.request.SaveCompanyRequest;
import com.smartorder.dto.request.UpdateCompanyRequest;
import com.smartorder.entity.Company;

public interface CompanyService {

    void saveCompany(SaveCompanyRequest request);

    void updateCompany(UpdateCompanyRequest request);

    Company findById(Long companyId);
}
