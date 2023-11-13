package com.smartorder.company.service;

import com.smartorder.company.controller.request.SaveCompanyRequest;
import com.smartorder.company.controller.request.UpdateCompanyRequest;
import com.smartorder.company.controller.response.SaveCompanyResponse;
import com.smartorder.company.controller.response.UpdateCompanyResponse;
import com.smartorder.company.entity.Company;

public interface CompanyService {

    SaveCompanyResponse saveCompany(SaveCompanyRequest request);

    UpdateCompanyResponse updateCompany(UpdateCompanyRequest request);

    Company findById(Long companyId);
}
