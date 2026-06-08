package com.Ecom.E_commerce.Dto.Request;

public record CreateCartItemsDto(
        Integer car_qty,
        Integer cart_id,
        Integer pro_id
) {}