package com.Ecom.E_commerce.services.product_service;


import com.Ecom.E_commerce.exceptions.ApiRequestException;
import com.Ecom.E_commerce.mappers.ProductMapper;
import com.Ecom.E_commerce.models.Product;
import com.Ecom.E_commerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private  final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public String createProduct(String pro_id, String name, double price, String stock, String description) {
        Product product = productMapper.toproduct(pro_id, name, price, stock, description);
        productRepository.save(product);
        return "Product created";
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductId(String pro_id) {
        return productRepository.findById(pro_id).orElseThrow(()-> new ApiRequestException("Product ID not found"));
    }
}
