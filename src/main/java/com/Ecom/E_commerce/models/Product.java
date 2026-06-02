package com.Ecom.E_commerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "Product")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pro_id;

    @Column(nullable = false)
    private  String name;

    @Column(nullable = false)
    private  double price;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "product")
    private List<CartItems> cartItems;

    @OneToMany(mappedBy = "product")
    private  List<OrderItems> orderItems;

}
