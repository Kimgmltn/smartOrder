package com.smartorder.restaurantTable.service.impl;

import com.smartorder.restaurantTable.controller.request.SaveTablesRequest;
import com.smartorder.restaurantTable.controller.response.SaveTablesResponse;
import com.smartorder.restaurantTable.entity.RestaurantTable;
import com.smartorder.restaurantTable.repository.RestaurantTableRepository;
import com.smartorder.restaurantTable.service.RestaurantTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantTableServiceImpl implements RestaurantTableService {

    private final RestaurantTableRepository tableRepository;

    @Transactional
    @Override
    public SaveTablesResponse saveTables(SaveTablesRequest request) {
        Long companyId = request.getCompanyId();
        String text = "테이블 {count}개가 등록되었습니다.";
        List<RestaurantTable> tables = request.getTableNos().stream().map(no -> RestaurantTable.
                create(companyId, no)).collect(Collectors.toList());

        List<RestaurantTable> savedTables = tableRepository.saveAll(tables);
        String replace = text.replace("{count}", String.valueOf(savedTables.size()));
        return new SaveTablesResponse(replace);
    }
}
