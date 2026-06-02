package com.Ecom.E_commerce.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "CartItems")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CartItems {

    @Id
    private Integer cartItm_id;

    @Column(nullable = false)
    private  String car_qty;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private  Product product;



}
