package com.Ecom.E_commerce.repositories;
import com.Ecom.E_commerce.models.OrderItems;
import com.Ecom.E_commerce.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderItemsRepository extends  JpaRepository<OrderItems, Integer> {


    List<OrderItems> findByOrders(Orders orders);
}
