package com.smartorder.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="middle_category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MiddleCategory {
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
}
