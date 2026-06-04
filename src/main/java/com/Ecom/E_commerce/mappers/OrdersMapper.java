package com.Ecom.E_commerce.mappers;


import com.Ecom.E_commerce.models.OrderItems;
import com.Ecom.E_commerce.models.Orders;
import com.Ecom.E_commerce.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class OrdersMapper {
    public Orders toorders(Integer order_id, String total_amt, User user, List<OrderItems> orderItemsList){
        return Orders.builder()
                .order_id(order_id)
                .total_amt(total_amt)
                .user(user)
                .orderItems(orderItemsList)
                .build();
    }
}


