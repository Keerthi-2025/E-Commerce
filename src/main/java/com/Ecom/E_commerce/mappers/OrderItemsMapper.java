package com.Ecom.E_commerce.mappers;

import com.Ecom.E_commerce.models.OrderItems;
import com.Ecom.E_commerce.models.Orders;
import com.Ecom.E_commerce.models.Product;
import org.springframework.stereotype.Component;

@Component
public class OrderItemsMapper {

    public OrderItems tooorderitems(Integer orderItms_Id,
                                    Integer ord_qty,
                                    Orders orders,
                                    Product product) {

        return OrderItems.builder()
                .orderItms_Id(orderItms_Id)
                .ord_qty(ord_qty)
                .orders(orders)
                .product(product)
                .build();
    }
}