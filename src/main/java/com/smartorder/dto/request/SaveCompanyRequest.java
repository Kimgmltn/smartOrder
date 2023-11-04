package com.smartorder.dto.request;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SaveCompanyRequest {
    @NotEmpty
    private String companyName;
    private String CompanyCode;
    private String roadNameAddress;
    private String lotNumberAddress;
}
