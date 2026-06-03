package com.Ecom.E_commerce.repositories;

import com.Ecom.E_commerce.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, String> {
}
