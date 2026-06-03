package com.Ecom.E_commerce.mappers;


import com.Ecom.E_commerce.models.Cart;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {
    public Cart tocart(Integer cart_id){
        return Cart.builder()
                .cart_id(cart_id)
                .build();
    }
}
