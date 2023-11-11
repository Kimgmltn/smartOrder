package com.smartorder.company.service;

import com.smartorder.company.controller.request.SaveCompanyRequest;
import com.smartorder.company.controller.request.UpdateCompanyRequest;
import com.smartorder.company.controller.response.UpdateCompanyResponse;

public interface CompanyService {

    com.smartorder.company.controller.response.SaveCompanyResponse saveCompany(SaveCompanyRequest request);

    UpdateCompanyResponse updateCompany(UpdateCompanyRequest request);
}
