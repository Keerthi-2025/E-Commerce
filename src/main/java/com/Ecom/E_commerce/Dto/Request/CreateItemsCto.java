package com.Ecom.E_commerce.Dto.Request;

import com.Ecom.E_commerce.models.Product;

public record CreateItemsCto(Integer cartItm_id, String car_qty, Integer cart, Product product) {
}
