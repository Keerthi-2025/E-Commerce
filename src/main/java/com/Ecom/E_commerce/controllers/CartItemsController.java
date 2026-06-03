package com.Ecom.E_commerce.controllers;


import com.Ecom.E_commerce.Dto.Request.CreateCartItemsDto;
import com.Ecom.E_commerce.models.Cart;
import com.Ecom.E_commerce.models.CartItems;
import com.Ecom.E_commerce.services.cartitems_service.CartItemsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/v1/getAllCartItems")
    ResponseEntity<List<CartItems>>getAllCartItems()
    {
        return ResponseEntity.status(200).body(cartItemsService.getAllCartItems());
    }

    @GetMapping("/v1/getCartItemsById")
    ResponseEntity<CartItems> getCartItemsById(@RequestParam("cartItm_Id") Integer cartItm_Id){
        return ResponseEntity.status(200).body(cartItemsService.getCartItemsById(cartItm_Id));
    }
}
