package com.Ecom.E_commerce.mappers;


import com.Ecom.E_commerce.models.OrderItems;
import com.Ecom.E_commerce.models.Orders;
import com.Ecom.E_commerce.models.Product;
import org.springframework.stereotype.Component;

@Component

public record OrderItemsMapper() {
    public OrderItems toordeitems(Integer orderItms_id, String ord_qty, Orders orders, Product product){
        return OrderItems.builder()
                .orderItms_id(orderItms_id)
                .ord_qty(ord_qty)
                .order(orders)
                .product(product)
                .build();
    }
}
