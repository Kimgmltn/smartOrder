package com.smartorder.restaurantTable.service.impl;

import com.smartorder.restaurantTable.dto.request.SaveTablesRequest;
import com.smartorder.restaurantTable.dto.response.SaveTablesResponse;
import com.smartorder.restaurantTable.entity.RestaurantTable;
import com.smartorder.restaurantTable.exception.RestaurantTableException;
import com.smartorder.restaurantTable.repository.RestaurantTableRepository;
import com.smartorder.restaurantTable.service.RestaurantTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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

    @Override
    public RestaurantTable findByCompanyIdAndTableNo(Long companyId, String tableNo) {
        Optional<RestaurantTable> table = tableRepository.findByCompany_IdAndTableNo(companyId, tableNo);
        if (!table.isPresent()) {
            throw new RestaurantTableException("존재하지 않는 테이블입니다.");
        }
        return table.get();
    }

    @Override
    public RestaurantTable findByCompanyIdAndTableId(Long companyId, Long tableId) {
        Optional<RestaurantTable> table = tableRepository.findByCompany_IdAndId(companyId, tableId);
        if (!table.isPresent()) {
            throw new RestaurantTableException("존재하지 않는 테이블입니다.");
        }
        return table.get();
    }
}
