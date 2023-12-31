package com.smartorder.company.entity;

import com.smartorder.category.entity.Category;
import com.smartorder.common.entity.BaseEntity;
import com.smartorder.company.dto.request.SaveCompanyRequest;
import com.smartorder.company.dto.request.UpdateCompanyRequest;
import com.smartorder.restaurantTable.entity.RestaurantTable;
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
    private List<Category> categories = new ArrayList<>();

    public Company(Long companyId) {
        this.id = companyId;
    }

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
