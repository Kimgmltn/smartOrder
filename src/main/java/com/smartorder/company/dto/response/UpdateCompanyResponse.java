package com.smartorder.company.dto.response;

import com.smartorder.company.entity.Company;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCompanyResponse {
    private Long companyId;
    private String companyName;
    private String roadNameAddress;

    public static UpdateCompanyResponse fromEntityToResponse(Company company) {
        return UpdateCompanyResponse.builder()
                .companyId(company.getId())
                .companyName(company.getCompanyName())
                .roadNameAddress(company.getRoadNameAddress())
                .build();
    }
}
