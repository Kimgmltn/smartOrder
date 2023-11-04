package com.smartorder.restController;

import com.smartorder.dto.request.SaveCompanyRequest;
import com.smartorder.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/company")
public class CompanyController {
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<Void> saveCompany(@Validated @RequestBody SaveCompanyRequest request){
        companyService.saveCompany(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity findAllCompany(){

        return null;
    }

}
