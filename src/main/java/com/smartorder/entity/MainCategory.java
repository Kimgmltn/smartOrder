package com.smartorder.entity;

import com.smartorder.common.entity.BaseEntity;
import com.smartorder.company.entity.Company;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "main_category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class MainCategory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "main_category_id")
    private Long mainCategoryId;
    @Column(name = "main_category_name")
    private String mainCategoryName;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;
    @OneToMany(mappedBy = "mainCategory")
    private List<MiddleCategory> middleCategories = new ArrayList<>();

    public MainCategory(Long mainCategoryId) {
        this.mainCategoryId = mainCategoryId;
    }
}
