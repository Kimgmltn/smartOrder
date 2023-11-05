package com.smartorder.dto.request;

import com.smartorder.enums.TableStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveTableRequest {
    private Long companyId;
    private String tableNo;
}