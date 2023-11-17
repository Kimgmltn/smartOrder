package com.smartorder.company.dto.response;

import com.smartorder.company.entity.Company;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class SaveCompanyResponse {
    private Long companyId;
    private String companyName;
    private String roadNameAddress;

    public static SaveCompanyResponse fromEntityToResponse(Company savedCompany) {
        return SaveCompanyResponse.builder()
                .companyId(savedCompany.getId())
                .companyName(savedCompany.getCompanyName())
                .roadNameAddress(savedCompany.getRoadNameAddress())
                .build();
    }
}
