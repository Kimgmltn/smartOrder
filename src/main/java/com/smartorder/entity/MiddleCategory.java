package com.smartorder.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="middle_category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class MiddleCategory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "middle_category_id")
    private Long middleCategoryId;
    @Column(name = "middle_category_name")
    private String middleCategoryName;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "main_category_id")
    private MainCategory mainCategory;
    @OneToMany(mappedBy = "middleCategory")
    private List<Item> items = new ArrayList<>();

    public MiddleCategory(Long middleCategoryId) {
        this.middleCategoryId = middleCategoryId;
    }
}
