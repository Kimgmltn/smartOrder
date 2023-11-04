package com.smartorder.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCompanyRequest {
    private Long companyId;
    private String companyName;
    private String CompanyCode;
    private String roadNameAddress;
    private String lotNumberAddress;
}
