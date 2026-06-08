package com.Ecom.E_commerce.services.cartitems_service;

import com.Ecom.E_commerce.models.CartItems;

import java.util.List;

public interface CartItemsService {

    String addItemToCart(Integer cartItm_id, Integer car_qty, Integer cart_id, Integer pro_id);

    CartItems getCartItemsById(Integer cartItm_id);

    List<CartItems> getAllCartItems();


}
