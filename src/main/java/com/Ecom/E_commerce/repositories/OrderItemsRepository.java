package com.Ecom.E_commerce.repositories;
import com.Ecom.E_commerce.models.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemsRepository extends  JpaRepository<OrderItems, Integer> {



}
