package com.Ecom.E_commerce.Dto.Request;

import com.Ecom.E_commerce.models.Orders;
import com.Ecom.E_commerce.models.Product;

public record CreateOrderItemsDto(Integer orderItms_Id, Integer ord_qty, Integer orders, Integer product) {
}
