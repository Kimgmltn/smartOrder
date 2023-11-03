package com.smartorder.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="company")
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Company extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
    private Long companyId;
    @Column(name="company_code")
    private String companyCode;
    @Column(name="company_name")
    private String companyName;
    @Column(name="road_name_address")
    private String roadNameAddress;
    @Column(name="lot_number_address")
    private String lotNumberAddress;

    @OneToMany(mappedBy = "company")
    private List<RestaurantTable> restaurantTables = new ArrayList<>();
    @OneToMany(mappedBy = "company")
    private List<MainCategory> mainCategories = new ArrayList<>();

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setRoadNameAddress(String roadNameAddress) {
        this.roadNameAddress = roadNameAddress;
    }

    public void setLotNumberAddress(String lotNumberAddress) {
        this.lotNumberAddress = lotNumberAddress;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
