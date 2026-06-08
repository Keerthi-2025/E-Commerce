package com.Ecom.E_commerce.services.orderitems_service;

import com.Ecom.E_commerce.models.OrderItems;

import java.util.List;

public interface OrderItemsService {

    String addOrderItem(Integer orderItms_Id, Integer ord_qty, Integer order_id, Integer pro_id);

    OrderItems getOrderItemsById(Integer orderItms_Id);

    List<OrderItems> getAllOrderItems();

    String updateOrderItems(Integer orderItms_Id, Integer ord_qty);

    String deleteOrderItems(Integer orderItems_Id);

    String checkStock(Integer pro_id, Integer ord_qty);

    String reduceStock(Integer pro_id, Integer ord_qty);

    String getTotalItemsInOrder(Integer order_id);

    List<OrderItems> getByOrderId(Integer orderId);
}
