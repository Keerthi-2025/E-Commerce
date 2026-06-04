//package com.Ecom.E_commerce.repositories;
//
//import com.Ecom.E_commerce.models.Orders;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface OrdersRepository extends JpaRepository<Orders, Integer> {
//}


package com.Ecom.E_commerce.repositories;

import com.Ecom.E_commerce.models.Orders;
import com.Ecom.E_commerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    List<Orders> findByUser(User user);
}