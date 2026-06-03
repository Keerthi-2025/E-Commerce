package com.Ecom.E_commerce.controllers;


import com.Ecom.E_commerce.Dto.Request.CreateCartItemsDto;
import com.Ecom.E_commerce.services.cartitems_service.CartItemsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/CartItems")

public class CartItemsController {
    private final CartItemsService cartItemsService;

    public CartItemsController(CartItemsService cartItemsService){
        this.cartItemsService = cartItemsService;
    }

    @PostMapping("/add")
    public ResponseEntity<String>createcart(@RequestBody CreateCartItemsDto data){
        String message = cartItemsService.addItemToCart(data.cartItm_id(), data.car_qty(), data.cart_id(),data.pro_id());
        return ResponseEntity.status(201).body(message);
    }
}
