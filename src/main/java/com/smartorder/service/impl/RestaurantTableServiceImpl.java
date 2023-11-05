package com.smartorder.service.impl;

import com.smartorder.dto.request.SaveTableRequest;
import com.smartorder.entity.Company;
import com.smartorder.entity.RestaurantTable;
import com.smartorder.enums.TableStatus;
import com.smartorder.repository.RestaurantTableRepository;
import com.smartorder.service.CompanyService;
import com.smartorder.service.RestaurantTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantTableServiceImpl implements RestaurantTableService {

    private final RestaurantTableRepository tableRepository;
    private final CompanyService companyService;

    @Override
    public void saveTable(SaveTableRequest request) {
        Company company = companyService.findById(request.getCompanyId());
        RestaurantTable table = RestaurantTable.builder()
                .company(company)
                .tableNo(request.getTableNo())
                .tableStatus(TableStatus.EMPTY)
                .build();
        tableRepository.save(table);
    }
}
