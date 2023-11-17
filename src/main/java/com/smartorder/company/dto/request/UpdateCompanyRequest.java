package com.smartorder.company.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCompanyRequest {
    @Schema(example = "1")
    @NotNull
    private Long companyId;
    @Schema(example = "회사명")
    private String companyName;
    @Schema(example = "도로명 주소")
    private String roadNameAddress;
}
