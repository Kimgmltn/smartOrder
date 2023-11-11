package com.smartorder.company.controller;

import com.smartorder.company.controller.request.SaveCompanyRequest;
import com.smartorder.company.controller.request.UpdateCompanyRequest;
import com.smartorder.company.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/company")
@Tag(name="회사", description = "회사 등록 및 수정 controller")
public class CompanyController {

    private final CompanyService companyService;

    @Operation(summary = "회사 등록")
    @PostMapping
    public ResponseEntity<Void> saveCompany(@Validated @RequestBody SaveCompanyRequest request){
        companyService.saveCompany(request);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "회사 정보 수정")
    @PatchMapping
    public ResponseEntity<Void> updateCompany(@RequestBody UpdateCompanyRequest request){
//        companyService.updateCompany(request);
        return ResponseEntity.ok().build();
    }

}
