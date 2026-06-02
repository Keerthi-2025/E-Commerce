package com.Ecom.E_commerce.mappers;


import com.Ecom.E_commerce.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toproduct(Integer pro_id, String name, double price, Integer stock, String description){
        return Product.builder()
                .pro_id(pro_id)
                .name(name)
                .price(price)
                .stock(stock)
                .description(description)
                .build();
    }
}
