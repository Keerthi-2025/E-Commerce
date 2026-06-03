package com.Ecom.E_commerce.controllers;


import com.Ecom.E_commerce.Dto.Request.CreateProductDto;
import com.Ecom.E_commerce.models.Product;
import com.Ecom.E_commerce.services.product_service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Product")

public class ProductController {
    private final ProductService productService;

    public  ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/v1/createproduct")
    public ResponseEntity<String> createproduct(@RequestBody CreateProductDto data){
        String message = productService.createProduct(data.pro_id(), data.name(), data.price(), Integer.valueOf(data.stock()), data.description());
        return  ResponseEntity.status(201).body(message);
    }

    @GetMapping("/v1/getAllProducts")
    ResponseEntity<List<Product>>getAllProducts(){
        return  ResponseEntity.status(200).body(productService.getAllProducts());
    }

    @GetMapping("/v1/getProductId")
    ResponseEntity <Product>getProductId(@RequestParam("pro_id") Integer pro_id){
        return  ResponseEntity.status(200).body(productService.getProductId(pro_id));
    }
}
