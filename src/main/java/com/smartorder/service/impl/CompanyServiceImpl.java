package com.smartorder.service.impl;

import com.querydsl.core.QueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smartorder.dto.request.SaveCompanyRequest;
import com.smartorder.dto.request.UpdateCompanyRequest;
import com.smartorder.entity.Company;
import com.smartorder.exception.CompanyException;
import com.smartorder.repository.CompanyRepository;
import com.smartorder.service.CompanyService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final JPAQueryFactory query;

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
        company.changeCompanyInfo(request.getCompanyName(), request.getCompanyCode(),request.getRoadNameAddress(), request.getLotNumberAddress());
        companyRepository.save(company);
    }

    public void findAllCompany(){



    }


}
