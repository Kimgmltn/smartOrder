package com.smartorder.restaurantTable.controller;

import com.smartorder.restaurantTable.controller.request.SaveTablesRequest;
import com.smartorder.restaurantTable.service.RestaurantTableService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/restaurantTable")
@Tag(name="식당 테이블", description = "테이블 등록 및 상태변환")
public class RestaurantTableController {
    private final RestaurantTableService restaurantTableService;

    @Operation(summary = "테이블 등록")
    @PostMapping
    public ResponseEntity<Void> saveTable(SaveTablesRequest request) {
        restaurantTableService.saveTables(request);
        return ResponseEntity.ok().build();
    }
}
