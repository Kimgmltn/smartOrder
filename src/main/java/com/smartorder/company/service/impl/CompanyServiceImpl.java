package com.smartorder.company.service.impl;

import com.smartorder.company.controller.request.SaveCompanyRequest;
import com.smartorder.company.controller.request.UpdateCompanyRequest;
import com.smartorder.company.controller.response.SaveCompanyResponse;
import com.smartorder.company.controller.response.UpdateCompanyResponse;
import com.smartorder.company.entity.Company;
import com.smartorder.company.exception.CompanyException;
import com.smartorder.company.repository.CompanyJpaRepository;
import com.smartorder.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyJpaRepository companyRepository;

    @Transactional
    @Override
    public SaveCompanyResponse saveCompany(SaveCompanyRequest request){
        Company company = Company.createCompany(request);
        Company savedCompany = companyRepository.save(company);

        return SaveCompanyResponse.fromEntityToResponse(savedCompany);
    }

    @Transactional
    @Override
    public UpdateCompanyResponse updateCompany(UpdateCompanyRequest request) {
        Company company = Company.updateCompany(request);
        Company updatedCompany = companyRepository.save(company);
        UpdateCompanyResponse response = UpdateCompanyResponse.fromEntityToResponse(updatedCompany);
        return response;
    }

    @Override
    public Company findById(Long companyId) {
        Optional<Company> company = companyRepository.findById(companyId);
        if(!company.isPresent()){
            throw new CompanyException("존재하지 않는 회사입니다.");
        }
        return company.get();
    }
}
