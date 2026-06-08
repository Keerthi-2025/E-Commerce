//package com.Ecom.E_commerce.services.orders_service;
//
//import com.Ecom.E_commerce.models.Orders;
//import com.Ecom.E_commerce.models.User;
//
//import java.util.List;
//
//public interface OrdersService {
//
//    String createOrders(Integer order_id, String total_amt, String user_id, List<Integer> orderItemsList);
//
//    Orders getOrdersById(Integer order_id);
//
//    List<Orders> getAllOrders();
//
//    List<Orders> findByUser(User user);
//
//}


package com.Ecom.E_commerce.services.orders_service;

import com.Ecom.E_commerce.models.Orders;
import com.Ecom.E_commerce.models.User;

import java.util.List;

public interface OrdersService {

    String createOrders(
            Integer order_id,
            String total_amt,
            String user_id
    );

    Orders getOrdersById(Integer order_id);

    List<Orders> getAllOrders();

    List<Orders> findByUser(User user);

    String checkout(Integer userId);

}