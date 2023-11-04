package com.smartorder.service;

import com.smartorder.dto.request.SaveCompanyRequest;
import com.smartorder.dto.request.UpdateCompanyRequest;

public interface CompanyService {

    void saveCompany(SaveCompanyRequest request);

    void updateCompany(UpdateCompanyRequest request);
}
