package com.Ecom.E_commerce.services.cart_service;

import com.Ecom.E_commerce.models.Cart;
import org.springframework.stereotype.Service;

import java.util.List;



public interface CartService {
    String createCart(Integer cart_id);

    List<Cart> getAllCarts();

    Cart getCartById(String cart_id);

//    String deleteCart(Integer cart_id);
}
