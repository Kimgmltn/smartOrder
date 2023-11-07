package com.smartorder.service.impl;

import com.smartorder.dto.request.SaveOrdersRequest;
import com.smartorder.entity.*;
import com.smartorder.enums.TableStatus;
import com.smartorder.repository.*;
import com.smartorder.service.OrdersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @InjectMocks
    private OrdersService ordersService;

    @Mock
    private OrdersRepository ordersRepository;

//    @Autowired
    @Mock
    private static CompanyRepository companyRepository;
//    @Autowired
    @Mock
    private static MainCategoryRepository mainCategoryRepository;
//    @Autowired
@Mock
    private static MiddleCategoryRepository middleCategoryRepository;
//    @Autowired
@Mock
    private static ItemRepository itemRepository;
//    @Autowired
@Mock
    private static RestaurantTableRepository restaurantTableRepository;

    @BeforeEach
    void init(){
        Company company = Company.builder().companyName("갈비").build();
        MainCategory mainCategory = MainCategory.builder().company(company).mainCategoryName("고기").build();
        MiddleCategory middleCategory = MiddleCategory.builder().mainCategory(mainCategory).middleCategoryName("갈비").build();
        Item item1 = Item.builder().middleCategory(middleCategory).itemName("돼지갈비").price(17000).build();
        Item item2 = Item.builder().middleCategory(middleCategory).itemName("즉석소양념갈비").price(19000).build();
        RestaurantTable restaurantTable = RestaurantTable.builder().company(company).tableNo("1").tableStatus(TableStatus.EMPTY).build();

        given(companyRepository.save(any(Company.class))).willReturn(company);
        given(mainCategoryRepository.save(any(MainCategory.class))).willReturn(mainCategory);
        given(middleCategoryRepository.save(any(MiddleCategory.class))).willReturn(middleCategory);
        given(itemRepository.save(item1)).willReturn(item1);
        given(itemRepository.save(item2)).willReturn(item2);
        given(restaurantTableRepository.save(any(RestaurantTable.class))).willReturn(restaurantTable);
    }

    @Test
    @DisplayName("선택한 메뉴가 없으면 실패")
    void noItemToFail(){
        // 주문 요청
        SaveOrdersRequest request = createSaveOrderRequest();

        // 주문 넣기
//        ordersService.saveOrdersAndItemOrder(request);



    }

    private SaveOrdersRequest createSaveOrderRequest() {
        SaveOrdersRequest request = new SaveOrdersRequest();
        List<SaveOrdersRequest.ItemOrderRequest> itemList = new ArrayList<>();
        itemList.add(new SaveOrdersRequest.ItemOrderRequest(1L, 3));
        request.setTableId(1L);
        return request;
    }

}