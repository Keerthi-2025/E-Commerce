package com.Ecom.E_commerce.services.orders_service;

import com.Ecom.E_commerce.models.OrderItems;
import com.Ecom.E_commerce.models.Orders;
import com.Ecom.E_commerce.models.User;

import java.util.List;

public interface OrdersService {

    String createOrders( Integer order_id, String total_amt, String user_id, List<OrderItems> orderItemsList);

    Orders getOrdersById(Integer order_id);

    List<Orders> getAllOrders();

    List<Orders> findByUser(User user);

}
