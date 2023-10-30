package com.smartorder.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "main_category")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MainCategory {
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

}
