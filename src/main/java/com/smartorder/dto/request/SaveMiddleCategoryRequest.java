package com.smartorder.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveMiddleCategoryRequest {
    private Long mainCategoryId;
    private String middleCategoryName;
}
