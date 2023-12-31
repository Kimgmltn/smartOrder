package com.smartorder.company.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SaveCompanyRequest {
    @NotBlank
    @Schema(example = "회사명")
    private String companyName;
    @Schema(example = "도로명 주소")
    private String roadNameAddress;
}
