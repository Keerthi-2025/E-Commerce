package com.Ecom.E_commerce.controllers;


import com.Ecom.E_commerce.Dto.Request.CreateCartDto;
import com.Ecom.E_commerce.models.Cart;
import com.Ecom.E_commerce.services.cart_service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Cart")

public class CartController {

    private final CartService cartService;

    public  CartController(CartService cartService){
        this.cartService = cartService;
    }

    @PostMapping("/v1/createcart")
    public ResponseEntity<String> createcart(@RequestBody CreateCartDto data){
        String message = cartService.createCart(data.cart_id());
        return ResponseEntity.status(201).body(message);
    }

    @GetMapping("/v1/getAllCarts")
    ResponseEntity<List<Cart>>getAllCarts(){
        return  ResponseEntity.status(200).body(cartService.getAllCarts());
    }

    @GetMapping("/v1/getCartById")
    ResponseEntity <Cart>getCartById(@RequestParam("cart_id") String cart_id) {
        return ResponseEntity.status(200).body(cartService.getCartById(cart_id));
    }
}
