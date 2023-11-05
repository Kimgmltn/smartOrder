package com.smartorder.service.impl;

import com.smartorder.dto.request.SaveTableRequest;
import com.smartorder.entity.Company;
import com.smartorder.entity.RestaurantTable;
import com.smartorder.enums.TableStatus;
import com.smartorder.repository.RestaurantTableRepository;
import com.smartorder.service.RestaurantTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantTableServiceImpl implements RestaurantTableService {

    private final RestaurantTableRepository tableRepository;

    @Override
    public void saveTable(SaveTableRequest request) {
        RestaurantTable table = RestaurantTable.builder()
                .company(new Company(request.getCompanyId()))
                .tableNo(request.getTableNo())
                .tableStatus(TableStatus.EMPTY)
                .build();
        tableRepository.save(table);
    }
}
