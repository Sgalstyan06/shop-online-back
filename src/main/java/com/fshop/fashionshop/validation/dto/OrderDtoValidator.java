package com.fshop.fashionshop.validation.dto;

import com.fshop.fashionshop.model.dto.requestDto.OrderUpdateReqDto;
import com.fshop.fashionshop.validation.ValidationConstants;

public final class OrderDtoValidator {


    public static boolean chekOrderUpdateDto(OrderUpdateReqDto dto) {
        return dto.getCount() >= ValidationConstants.ORDER_PRODUCT_COUNT_MIN_VALUE &&
                dto.getCount() <= ValidationConstants.ORDER_PRODUCT_COUNT_MAX_VALUE;
    }
}
