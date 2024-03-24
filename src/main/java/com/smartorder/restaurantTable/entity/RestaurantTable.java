package com.smartorder.restaurantTable.entity;

import com.smartorder.common.entity.BaseEntity;
import com.smartorder.company.entity.Company;
import com.smartorder.orders.entity.Orders;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurant_table")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantTable extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "table_id")
    private Long id;
    @Column(name = "table_no")
    private String tableNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_id")
    private Company company;
    @OneToMany(mappedBy = "table")
    private List<Orders> orders = new ArrayList<>();

    public RestaurantTable(Long tableId) {
        this.id = tableId;
    }

    public RestaurantTable(Long companyId, Long tableId){
        this.id = tableId;
        this.company = new Company(companyId);
    }

    public static RestaurantTable create(Long companyId, String tableNo) {
        return RestaurantTable.builder()
                .tableNo(tableNo)
                .company(new Company(companyId))
                .build();
    }
}
