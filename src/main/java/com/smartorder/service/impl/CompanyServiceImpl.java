package com.smartorder.service.impl;

import com.smartorder.dto.request.SaveCompanyRequest;
import com.smartorder.dto.request.UpdateCompanyRequest;
import com.smartorder.entity.Company;
import com.smartorder.exception.CompanyException;
import com.smartorder.repository.CompanyRepository;
import com.smartorder.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public void saveCompany(SaveCompanyRequest request){
        Company company = Company.builder()
                .companyName(request.getCompanyName())
                .companyCode(request.getCompanyCode())
                .roadNameAddress(request.getRoadNameAddress())
                .lotNumberAddress(request.getLotNumberAddress())
                .build();
        companyRepository.save(company);
    }

    @Override
    public void updateCompany(UpdateCompanyRequest request){
        Company company = companyRepository.findById(request.getCompanyId()).orElseThrow(() -> new CompanyException("등록되지 않은 회사입니다."));
    }


}
