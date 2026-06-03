package com.Ecom.E_commerce.repositories;

import com.Ecom.E_commerce.models.CartItems;
import com.Ecom.E_commerce.services.cartitems_service.CartItemsService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, Integer> {
}
