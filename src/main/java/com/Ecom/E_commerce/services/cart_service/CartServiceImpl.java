package com.Ecom.E_commerce.services.cart_service;

import com.Ecom.E_commerce.exceptions.ApiRequestException;
import com.Ecom.E_commerce.mappers.CartMapper;
import com.Ecom.E_commerce.models.Cart;
import com.Ecom.E_commerce.repositories.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class CartServiceImpl  implements CartService{
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    public CartServiceImpl(CartRepository cartRepository, CartMapper cartMapper){
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    @Override
    public String createCart(Integer cart_id) {
        Cart cart = cartMapper.tocart(cart_id);
        cartRepository.save(cart);
        return "cart created";
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart getCartById(String cart_id) {
        return cartRepository.findById(cart_id).orElseThrow(()-> new ApiRequestException("Cart ID not found"));
    }

//    @Override
//    public String deleteCart(Integer cart_id) {
//        return "";
//    }
}
