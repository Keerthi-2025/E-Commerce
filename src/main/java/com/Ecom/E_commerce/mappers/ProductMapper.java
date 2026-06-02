package com.Ecom.E_commerce.mappers;


import com.Ecom.E_commerce.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toproduct(String pro_id, String name, double price, String stock, String description){
        return Product.builder()
                .pro_id(pro_id)
                .name(name)
                .price(price)
                .stock(stock)
                .description(description)
                .build();
    }
}
