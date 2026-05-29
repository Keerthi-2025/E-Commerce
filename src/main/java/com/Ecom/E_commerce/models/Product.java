package com.Ecom.E_commerce.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Product")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Product {

    @Id
    private String pro_id;

    @Column(nullable = false)
    private  String name;

    @Column(nullable = false)
    private  double price;

    @Column(nullable = false)
    private String stock;

    @Column(nullable = false)
    private String description;

}
