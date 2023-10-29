package com.smartorder.entity;

import com.smartorder.enums.TableStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurant_table")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "table_id")
    private Long tableId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_id")
    private Company company;
    @Column(name = "table_no")
    private String tableNo;
    @Column(name="table_status")
    @Enumerated(EnumType.STRING)
    private TableStatus tableStatus;
    @OneToMany(mappedBy = "table")
    private List<Orders> orders = new ArrayList<>();

}
