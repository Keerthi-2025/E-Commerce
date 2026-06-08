package com.Ecom.E_commerce.mappers;

import com.Ecom.E_commerce.models.Cart;
import com.Ecom.E_commerce.models.CartItems;
import com.Ecom.E_commerce.models.Product;
import org.springframework.stereotype.Component;

@Component
public class CartItemsMapper {

    public CartItems tocartitems(
            Integer car_qty,
            Cart cart,
            Product product
    ) {
        return CartItems.builder()
                .car_qty(car_qty)
                .cart(cart)
                .product(product)
                .build();
    }
}