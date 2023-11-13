package com.smartorder.category.entity;

import com.smartorder.common.entity.BaseEntity;
import com.smartorder.company.entity.Company;
import com.smartorder.category.controller.request.SaveCategoryRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Long id;
    @Column(name = "category_name")
    private String categoryName;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    public Category(Long mainCategoryId) {
        this.id = mainCategoryId;
    }

    public static Category create(Long companyId, String categoryName) {
        return Category.builder()
                .company(new Company(companyId))
                .categoryName(categoryName)
                .build();
    }
}
