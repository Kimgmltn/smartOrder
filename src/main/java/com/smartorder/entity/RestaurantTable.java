package com.smartorder.entity;

import com.smartorder.enums.TableStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
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
    private Long tableId;
    @Column(name = "table_no")
    private String tableNo;
    @Column(name="table_status")
    @Enumerated(EnumType.STRING)
    private TableStatus tableStatus;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_id")
    private Company company;
    @OneToMany(mappedBy = "table")
    private List<Orders> orders = new ArrayList<>();
}
