package com.Ecom.E_commerce.services.product_service;

import com.Ecom.E_commerce.models.Product;

import java.util.List;

public interface ProductService {
    String createProduct(Integer pro_id, String name, double price, Integer stock, String description);

    List<Product> getAllProducts();

    Product getProductId(String pro_id);
}
