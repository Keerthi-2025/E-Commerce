package com.Ecom.E_commerce.services.product_service;

import com.Ecom.E_commerce.models.Product;

import java.util.List;

public interface ProductService {
    String createProduct(String pro_id, String name, double price, String stock, String description);

    List<ProductService> getAllProducts();

    Product getProductId(String pro_id);
}
