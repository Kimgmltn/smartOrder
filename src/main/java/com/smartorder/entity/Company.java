package com.smartorder.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="company")
@Getter
public class Company {
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
}
