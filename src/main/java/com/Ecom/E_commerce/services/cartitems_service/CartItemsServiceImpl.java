package com.Ecom.E_commerce.services.cartitems_service;


import com.Ecom.E_commerce.exceptions.ApiRequestException;
import com.Ecom.E_commerce.mappers.CartItemsMapper;
import com.Ecom.E_commerce.models.Cart;
import com.Ecom.E_commerce.models.CartItems;
import com.Ecom.E_commerce.models.Product;
import com.Ecom.E_commerce.repositories.CartItemsRepository;
import com.Ecom.E_commerce.repositories.CartRepository;
import com.Ecom.E_commerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemsServiceImpl implements  CartItemsService {
    private final CartItemsRepository cartItemsRepository;
    private final CartItemsMapper cartItemsMapper;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartItemsServiceImpl(CartItemsRepository cartItemsRepository, CartItemsMapper cartItemsMapper, CartRepository cartRepository, ProductRepository productRepository){
        this.cartItemsRepository = cartItemsRepository;
        this.cartItemsMapper = cartItemsMapper;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public String addItemToCart(
            Integer cartItm_id,
            Integer car_qty,
            Integer cart_id,
            Integer pro_id
    ) {

        Cart cart = cartRepository.findById(cart_id)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        Product product = productRepository.findById(pro_id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItems cartItems = cartItemsMapper.tocartitems(
                cartItm_id,
                car_qty,
                cart,
                product
        );

       cartItemsRepository.save(cartItems);

        return "Items are added to cart successfully";
    }
    @Override
    public CartItems getCartItemsById(Integer cartItm_id) {
        return  cartItemsRepository.findById(cartItm_id).orElseThrow(()-> new ApiRequestException("items not found in the cart"));
    }

    @Override
    public List<CartItems> getAllCartItems() {
        return cartItemsRepository.findAll();
    }
}
