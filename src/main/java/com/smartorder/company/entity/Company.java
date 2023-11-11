package com.smartorder.company.entity;

import com.smartorder.common.entity.BaseEntity;
import com.smartorder.company.controller.request.SaveCompanyRequest;
import com.smartorder.company.controller.request.UpdateCompanyRequest;
import com.smartorder.entity.MainCategory;
import com.smartorder.entity.RestaurantTable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="company")
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Company extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
    private Long id;
    @Column(name="company_name")
    private String companyName;
    @Column(name="road_name_address")
    private String roadNameAddress;

    @OneToMany(mappedBy = "company")
    private List<RestaurantTable> restaurantTables = new ArrayList<>();
    @OneToMany(mappedBy = "company")
    private List<MainCategory> mainCategories = new ArrayList<>();


    public static Company createCompany(SaveCompanyRequest request) {
        return Company.builder()
                .companyName(request.getCompanyName())
                .roadNameAddress(request.getRoadNameAddress())
                .build();
    }

    public static Company updateCompany(UpdateCompanyRequest request) {
        return Company.builder()
                .id(request.getCompanyId())
                .companyName(request.getCompanyName())
                .roadNameAddress(request.getRoadNameAddress())
                .build();
    }
}
